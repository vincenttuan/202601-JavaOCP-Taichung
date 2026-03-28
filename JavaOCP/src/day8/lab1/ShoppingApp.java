package day8.lab1;

/**
 * 設計一個電商系統(ShoppingApp)
 * 系統元件:
 * 使用者(User) -> 一般內部類別
 * 折扣(Discount) -> 方法內部類別
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
	}
	
	
}
