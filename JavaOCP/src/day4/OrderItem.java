package day4;

// 單一飲料的訂單項目
public class OrderItem {
	
	// 物件屬性
	private Drink drink; // 飲料物件
	private int quantity; // 訂購數量
	
	// 建立一個建構子來設定屬性資料
	public OrderItem(Drink drink, int quantity) {
		this.drink = drink;
		this.quantity = quantity;
	}
	
	// getter
	// getTotalPrice()：回傳這筆訂單小計
	public int getTotalPrice() {
		// 飲料的價格 * 訂購數量 => drink 的 price * quantity
		return drink.getPrice() * this.quantity;
	}
	
	public Drink getDrink() {
		return drink;
	}
	
	public int getQuantity() {
		return quantity;
	}
	
}
