package day10;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import day10.entity.Drink;
import day10.entity.Order;

public class DrinkDemo {

	public static void main(String[] args) {
		// List:所有訂單(每個人買甚麼)
		// Set:有哪些飲料被買(不重複飲品)
		// Map:每種飲品賣了幾杯
		
		// 飲品
		Drink d1 = new Drink(1, "珍珠奶茶");
		Drink d2 = new Drink(2, "香草拿鐵");
		Drink d3 = new Drink(3, "香檳汽水");
		
		// 訂單
		List<Order> orders = new ArrayList<>();
		orders.add(new Order(1001, List.of(d1, d2)));
		orders.add(new Order(1002, List.of(d1, d3)));
		orders.add(new Order(1003, List.of(d2, d3)));
		orders.add(new Order(1004, List.of(d1)));
		
		// Set 不重複飲品
		Set<String> uniqueDrinks = new HashSet<>();
		orders.forEach(order -> {
			
			order.getDrinks().forEach(drink -> {
				uniqueDrinks.add(drink.getName());
			});
			
		});
		System.out.println("有哪些飲料被買(不重複飲品) => " + uniqueDrinks);
									
		// Map 統計每種飲品賣了幾杯
		Map<String, Integer> salesMap = new HashMap<>();
		orders.forEach(order -> {
			
			order.getDrinks().forEach(drink -> {
				
				salesMap.put(drink.getName(), 
						     salesMap.getOrDefault(drink.getName(), 0) + 1);
				
			});
			
		});
		System.out.println(salesMap);
		
		// 最熱銷的飲品 (就是在 salesMap 中找到 value 最大的 key)
	}

}













