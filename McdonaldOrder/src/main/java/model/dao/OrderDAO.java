package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.management.RuntimeErrorException;

import model.dto.OrderDTO;
import model.dto.OrderItemDTO;
import util.DBUtil;

public class OrderDAO {
	
	private static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
	
	/**
	 * 查詢歷史訂單紀錄
	 * */
	public List<OrderDTO> findAllOrders() {
		 String sql = """
		 		select
					o.id as order_id,
				    o.customer_name,
				    o.customer_phone,
				    o.total_amount,
				    o.create_at,
				    i.id as item_id,
				    i.product_name,
				    i.unit_price,
				    i.quantity,
				    i.subtotal
				from customer_order o
				left join order_item i on i.order_id = o.id
				where i.id is not null
				order by o.create_at desc, o.id desc, i.id
		 		""";
		 
		 // Map<訂單Id, 訂單>
		 Map<Long, OrderDTO> orders = new LinkedHashMap<>();
		 
		 try(Connection conn = DBUtil.getConnection();
			 Statement stmt = conn.createStatement();
			 ResultSet rs = stmt.executeQuery(sql)) {
			
			 while (rs.next()) {
				 
				 Long orderId = rs.getLong("order_id");
				 
				 
				 // 判斷 order 是否已經新增到 orders
				 if(orders.get(orderId) == null) {
					 OrderDTO order = new OrderDTO();
					 order.setOrderId(orderId);
					 order.setCustomerName(rs.getString("customer_name"));
					 order.setCustomerPhone(rs.getString("customer_phone"));
					 order.setTotalAmount(rs.getLong("total_amount"));
					 order.setCreatedAt(rs.getTimestamp("create_at").toLocalDateTime().format(DATE_TIME_FORMATTER));
					 
					 orders.put(orderId, order);
				 }
				 
				 // 取 Order
				 OrderDTO order = orders.get(orderId);
				 
				 // 訂單細目
				 OrderItemDTO item = new OrderItemDTO();
				 item.setProductName(rs.getString("product_name"));
				 item.setUnitPrice(rs.getInt("unit_price"));
				 item.setQuantity(rs.getInt("quantity"));
				 item.setSubtotal(rs.getLong("subtotal"));
				 
				 order.getItems().add(item);
				 
				 
			 }
			 
		 } catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("訂單查詢失敗", e);
		}
		
		return new ArrayList<>(orders.values());
		
	}
	
	
	/** 建立訂單 
	 * 
	 * Transaction 交易
	 * --------------------
	 * 1. 查詢商品
	 * 2. 查詢庫存
	 * 3. 計算總金額
	 * 4. 建立 CustomerOrder
	 * 5. 建立 OrderItem
	 * 6. 扣除庫存
	 * --------------------
	 * 
	 * 成功 -> commit (提交任務)
	 * 
	 * 失敗 -> Rollback (回滾)
	 * 
	 * */
	public OrderDTO createOrder(String customerName, String customerPhone, List<OrderItemDTO> items) {
		
		// 查詢商品 sql 與 庫存
		String productSql = """
				select id, name, price, stock
				from product
				where id = ?
				""";
		
		// 新增訂單 sql
		String orderSql = """
				insert into customer_order (customer_name, customer_phone, total_amount, status)
				values(?, ?, ?, 'PAID');
				""";
		
		// 新增訂單項目 sql
		String itemSql = """
				insert into order_item (order_id, product_id, product_name, unit_price, quantity, subtotal)
				values(?, ?, ?, ?, ?, ?);
				""";
		
		// 修改商品庫存 sql
		String stockSql = """
				update product
				set stock = stock - ?
				where id = ?
				""";
		
		// 資料庫處理程序
		try(Connection conn = DBUtil.getConnection()) {
			// 1.開始 Transaction
			conn.setAutoCommit(false);
			
			long total = 0; // 總金額
			
			// 2.檢查商品存在與否 + 庫存 + 計算金額
			for(OrderItemDTO item : items) {
				
				PreparedStatement ps = conn.prepareStatement(productSql);
				ps.setLong(1,item.getProductId());
				
				ResultSet rs = ps.executeQuery();
				if(!rs.next()) {
					throw new RuntimeException("商品不存在: " + item.getProductId());
				}
				
				String name = rs.getString("name");
				int price = rs.getInt("price");
				int stock = rs.getInt("stock");
				
				// 庫存不足
				if(stock < item.getQuantity()) {
					throw new RuntimeException(name + "庫存不足");
				}
				
				// 計算小計
				long subTotal = (long)price * item.getQuantity();
				total += subTotal;
				
				ps.close();
				
			}
			
			// 3.建立訂單
			long orderId;
			try(PreparedStatement ps = conn.prepareStatement(orderSql, Statement.RETURN_GENERATED_KEYS)) {
			
				ps.setString(1, customerName);
				ps.setString(2, customerPhone);
				ps.setLong(3, total);
				
				ps.executeUpdate();
				
				// 取得資料庫自動產生的 id 值 (訂單編號)
				ResultSet rs = ps.getGeneratedKeys();
				
				if(!rs.next()) {
					throw new SQLException("無法取得訂單編號");
				}
				
				// 取得訂單編號
				orderId = rs.getLong(1);
			}
			
			// 4.建立明細 + 扣庫存
			for(OrderItemDTO item : items) {
				String name;
				int price;
				
				// 取得對新商品資訊
				try(PreparedStatement ps = conn.prepareStatement(productSql)) {
					
					ps.setLong(1, item.getProductId());
					
					ResultSet rs = ps.executeQuery();
					if(!rs.next()) {
						throw new RuntimeException("商品不存在: " + item.getProductId());
					}
					
					name = rs.getString("name");
					price = rs.getInt("price");
					
				}
				
				long subTotal = (long)price * item.getQuantity();
				
				// 新增 order_item
				try(PreparedStatement ps = conn.prepareStatement(itemSql)) {
					
					ps.setLong(1, orderId);
					ps.setLong(2, item.getProductId());
					ps.setString(3, name);
					ps.setInt(4, price); 
					ps.setInt(5, item.getQuantity());
					ps.setLong(6, subTotal);
					
					ps.executeUpdate();
				}
				
				// 扣庫存
				try(PreparedStatement ps = conn.prepareStatement(stockSql)) {
					ps.setInt(1, item.getQuantity());
					ps.setLong(2, item.getProductId());
					
					ps.executeUpdate();
				}
				
			}
			
			// 5.交易全部成功
			conn.commit();
			
			// 回傳 orderDTO
			OrderDTO orderDTO = new OrderDTO(orderId, total);
			return orderDTO;
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("結帳失敗", e);
		}
		
	}
	
	
}
