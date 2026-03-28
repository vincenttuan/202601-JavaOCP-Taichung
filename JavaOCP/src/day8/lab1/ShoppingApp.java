package day8.lab1;

/**
 * 設計一個電商系統(ShoppingApp)
 * 系統元件:
 * 使用者(User)
 * 折扣(Discount)
 * 付款(Payment)
 * 紀錄(Logger)
 * */
public class ShoppingApp {
	private String appName = "MyShop";
	// 讓 User 強烈依附在 ShoppingApp
	public class User {
		private String name;
		public User(String name) {
			this.name = name;
		}
		public void show() {
			System.out.printf("%s 使用 %s%n", name, appName);
		}
	}
}
