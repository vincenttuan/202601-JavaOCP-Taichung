package day10.entity;

import java.util.ArrayList;
import java.util.List;

public class Order {
	private Integer orderId; // 訂單編號
	private List<Drink> drinks; // 飲品列表
	
	public Order() {
		
	}
	
	public Order(Integer orderId, List<Drink> drinks) {
		this.orderId = orderId;
		this.drinks = drinks;
	}

	public Integer getOrderId() {
		return orderId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

	public List<Drink> getDrinks() {
		return drinks;
	}

	public void setDrinks(List<Drink> drinks) {
		this.drinks = drinks;
	}

	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", drinks=" + drinks + "]";
	}
	
}
