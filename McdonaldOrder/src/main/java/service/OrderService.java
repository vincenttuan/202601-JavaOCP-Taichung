package service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import model.dao.OrderDAO;
import model.dto.OrderDTO;
import model.dto.OrderItemDTO;
import model.dto.ProductDTO;

public class OrderService {
	
	private OrderDAO orderDAO = new OrderDAO();
	
	// 查詢所有訂單
	public List<OrderDTO> findAll() {
		return orderDAO.findAllOrders();
	}
	
	// 結帳服務
	// 將 Map<ProductDTO, Integer> cart 轉 List<OrderItemDTO> items
	public void checkout(String customerName, String customerPhone, Map<ProductDTO, Integer> cart) {
		
		List<OrderItemDTO> items = new ArrayList<>();
		for(ProductDTO dto : cart.keySet()) {
			OrderItemDTO item = new OrderItemDTO();
			item.setProductId(dto.getId());
			item.setQuantity(cart.get(dto));
			
			items.add(item);
		}
		
		// 建立訂單並存入資料表
		orderDAO.createOrder(customerName, customerPhone, items);
		
	}
	
}
