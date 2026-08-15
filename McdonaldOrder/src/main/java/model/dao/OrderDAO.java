package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import model.dto.OrderDTO;
import model.dto.OrderItemDTO;
import util.DBUtil;

public class OrderDAO {
	
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
			// 開始 Transaction
			conn.setAutoCommit(false);
			
			int total = 0; // 總金額
			
			// 檢查商品存在與否 + 庫存 + 計算金額
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
			
			// 建立訂單
			long orderId;
			PreparedStatement ps = conn.prepareStatement(orderSql, Statement.RETURN_GENERATED_KEYS);
			
			ps.setString(1, customerName);
			ps.setString(2, customerPhone);
			ps.setLong(3, total);
			
			// 取得資料庫自動產生的 id 值 (訂單編號)
			ResultSet rs = ps.getGeneratedKeys();
			
			if(!rs.next()) {
				throw new SQLException("無法取得訂單編號");
			}
			
			// 取得訂單編號
			orderId = rs.getLong(1);
			
			// 建立明細 + 扣庫存
			
			// 交易全部成功
			conn.commit();
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("結帳失敗", e);
		}
		
		
		return null;
	}
	
	
}
