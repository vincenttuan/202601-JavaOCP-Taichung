package day8.lab1;

import day7.lab1.Payment;

/**
 * 設計一個電商系統(ShoppingApp)
 * 系統元件:
 * 使用者(User) -> 一般內部類別
 * 折扣(Discount) -> 方法內部類別
 * 付款(Payment) -> 匿名內部類別
 * 紀錄(Logger) -> 靜態內部類別
 * */
public class ShoppingApp {
	private String appName = "MyShop";
	
	// 靜態內部類別
	public static class Logger {
		public static void log(String msg) {
			System.out.printf("[LOG] %s%n", msg);
		}
	}
	
	// 讓 User 強烈依附在 ShoppingApp
	// 一般內部類別
	public class User {
		private String name;
		public User(String name) {
			this.name = name;
		}
		public void show() {
			System.out.printf("%s 使用 %s%n", name, appName);
		}
	}
	
	interface Payment {
		void pay(int amount);
	}
	
	// Discount 只在 checkout() 方法中使用
	public void checkout(int total) {
		// 方法內部類別
		class Discount {
			int apply() {
				return (int)(total * 0.9);
			}
		}
		
		int finalPrice = new Discount().apply();
		System.out.printf("折扣前價格: %d%n", total);
		System.out.printf("折扣後價格: %d%n", finalPrice);
		
		// 匿名內部類別
		Payment payment = new Payment() {
			@Override
			public void pay(int amount) {
				System.out.printf("實際付款金額: %d%n", amount);
			}
		};
		
		payment.pay(finalPrice);
		
		// Log
		Logger.log("交易完成");
	}
	
	
}
