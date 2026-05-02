package day12;

import java.util.function.Predicate;

/**
 * 
 * Predicate 判斷
 * 
 * 輸入 T -> 回傳 boolean(true/false)
 * 
 @FunctionalInterface
 public interface Predicate<T> {
    boolean test(T t);
 }

 * */
public class TestPredicate {

	public static void main(String[] args) {
		// 判斷是否成年
		Predicate<Integer> isAduit = (age) -> age >= 18;
		int age = 20;
		System.out.printf("年齡: %d 是否成年: %b%n", age, isAduit.test(age));
		
		// 組合應用
		Predicate<String> notEmpty = (pwd) -> !(pwd == null && pwd.length() == 0);
		Predicate<String> hasLength = (pwd) -> pwd.length() >= 8;
		Predicate<String> hasSpecial = (pwd) -> pwd.contains("@");
		
		Predicate<String> isValidPassword = notEmpty.and(hasLength).and(hasSpecial);
		String password = "1234@5678";
		System.out.printf("密碼: %s 符合規範: %b%n", password, isValidPassword.test(password));
		
		// and / or 應用
		// 使用者想找 價格 <= 100
		// 且 評價 >= 4.0 或是促銷商品
		// ============================
		// 資料: "手機", 900,  4.5, false
		// 資料: "耳機", 500,  3.8, true
		// 資料: "筆電", 3000, 4.8, true
		// 資料: "滑鼠", 200,  4.1, false
		
	}
	
	// 內部類別
	class Product {
		String name;
		double price;
		double rating;
		boolean isSale;
		
		Product(String name, double price, double rating, boolean isSale) {
			super();
			this.name = name;
			this.price = price;
			this.rating = rating;
			this.isSale = isSale;
		}
		
	}

}







