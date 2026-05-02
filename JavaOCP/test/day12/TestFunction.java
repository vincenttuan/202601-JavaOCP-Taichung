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
		
		// 密碼設定規則
		// 不可空白 -> 必須 >= 8 個字 -> 必須要包含特殊字元@ -> 是否是符合密碼規範
		Function<String, Boolean> notEmpty        = (pwd) -> !(pwd == null || pwd.length() == 0);
		Function<String, Boolean> hasLength       = (pwd) -> pwd.length() >= 8;
		Function<String, Boolean> hasSpecial      = (pwd) -> pwd.contains("@");
		Function<String, Boolean> hasUpper        = (pwd) -> Character.isUpperCase(pwd.charAt(0)); // 增加字首大寫限制
		
		Function<String, Boolean> isValidPassword = (pwd) -> notEmpty.apply(pwd) && 
															 hasLength.apply(pwd) && 
															 hasSpecial.apply(pwd) &&
															 hasUpper.apply(pwd);
													
		String password = "A234@5678";
		System.out.printf("密碼: %s 符合規範: %b%n", password, isValidPassword.apply(password));
		
	}

}
