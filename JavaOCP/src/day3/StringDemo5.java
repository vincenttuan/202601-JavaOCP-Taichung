package day3;

import java.util.Arrays;

public class StringDemo5 {

	public static void main(String[] args) {
		String name = "Vincent,Jo,Anita,Howard,Alen,Rose,Bob";
		System.out.printf("原始資料: %s%n%n", name);
		// 1.請問有幾組人名 ?
		System.out.println("=== 題目 1 : 人名統計 ===");
		String[] names = name.split(",");
		int nameCount = names.length;
		System.out.printf("1.有 %d 組人名%n", nameCount);
		System.out.printf("  人名清單: %s%n%n", Arrays.toString(names));
		
		// 2.平均每個人名是幾個字 ?
		
		// 3.最長的名字是 ?
		
		// 4.最短的名字是 ?
		
		// 5.名字由短 -> 長排序並印出
		
	}

}
