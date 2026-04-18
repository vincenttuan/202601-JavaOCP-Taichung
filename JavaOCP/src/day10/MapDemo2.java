package day10;

import java.util.ArrayList;
import java.util.List;

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
		
		
		
	}
}
