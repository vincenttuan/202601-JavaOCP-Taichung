package day12;

import java.util.function.Function;

/**
 * Function 函式
 * 
 * 輸入 T -> 回傳 R
 * 
 @FunctionalInterface
 public interface Function<T,R> {
     R apply(T t);
 }
 * */
public class TestFunction {

	public static void main(String[] args) {
		// 輸入一個字串(T:String) -> 回傳長度(R:Integer)
		Function<String, Integer> func1 = (str) -> str == null ? null : str.length();
		String str = "Market";
		System.out.printf("字串: %s 字串長度: %d%n", str, func1.apply(str));
		
		// 商品折扣(8折)
		// 輸入商品價格(T:Integer) -> 回傳折扣後價格(R:Double)
		Function<Integer, Double> discount = price -> price * 0.8;
		Integer price = 100;
		System.out.printf("原價: %d 折扣後: %.1f%n", price, discount.apply(price));
		
	}

}
