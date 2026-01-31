package day2;

// 物件結構:買飲料訂單
public class DrinkOrder {
	// 3個資料(物件屬性)
	String drinkName; // 飲料名稱
	double price; // 單價
	int qty; // 購買數量
	
	// 建構子
	public DrinkOrder() {
		
	}
	
	public DrinkOrder(String drinkName, double price, int qty) {
		this.drinkName = drinkName;
		this.price = price;
		this.qty = qty;
	}
	
	// 2個邏輯(物件方法)
	private double calcTotal() { // 計算總金額
		double total = price * qty;
		return total;
	}
	
	public void printOrder() { // 印出訂單明細
		double total = calcTotal(); // 直接調用已經寫好的總金額計算邏輯
		System.out.println("飲料訂單明細:");
		System.out.printf("飲料: %s%n", drinkName);
		System.out.printf("單價: NT$ %.1f%n", price);
		System.out.printf("數量: %d%n", qty);
		System.out.printf("總金額: NT$ %.1f%n", total);
		System.out.println("================");
	}
	
}
