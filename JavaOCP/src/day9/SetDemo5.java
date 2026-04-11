package day9;

import java.util.Set;

public class SetDemo5 {
	public static void main(String[] args) {
		// 集合內容分析
		Set set1 = Set.of(100, 73, 80); 
		System.out.println(set1);
		// 輪循元素並印出
		for(Object data : set1) {
			System.out.println(data);
		}
		// 輪循元素並加總(加總前必須做轉換 Object -> Integer -> int)
		// 沒有使用泛型技術也沒有 autoUnboxing 技術的情況下
		int sum1 = 0;
		for(Object data : set1) {
			Integer d1 = (Integer)data; // Object  轉-> Integer
			int     d2 = d1.intValue(); // Integer 轉-> int
			sum1 += d2;
		}
		System.out.println("總和: " + sum1);
		
	}
}
