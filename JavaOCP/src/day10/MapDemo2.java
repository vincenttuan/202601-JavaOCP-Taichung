package day10;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import day10.entity.Product;

public class MapDemo2 {
	public static void main(String[] args) {
		List<Product> products = new ArrayList<>();
		products.add(new Product(101, "phone", 30000, 10));
		products.add(new Product(102, "pad", 20000, 20));
		products.add(new Product(103, "pod", 5000, 50));
		
		// 查詢 103 商品 -> 速度慢 -> O(N)
		for(Product product : products) {
			if(product.getId().equals(103)) {
				System.out.println(product.getName());
			}
		}
		
		// 利用 Map 特性快速查詢 -> 轉 Map (核心優化)
		Map<Integer, Product> productMap = new HashMap<>();
		for(Product product : products) {
			productMap.put(product.getId(), product);
		}
		
		// 查詢 103 商品 -> 速度極快 -> O(1)
		Product p = productMap.get(103);
		if(p != null) {
			System.out.println(p.getName());
		}
		
	}
}
