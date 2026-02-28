package day4;

// 飲料基本資料
public class Drink {
	// 物件屬性
	private int number; // 編號
	private String name; // 名稱
	private int price; // 價格
	
	// 建立一個建構子來設定屬性資料
	public Drink(int number, String name, int price) {
		this.number = number;
		this.name = name;
		this.price = price;
	}
	
	// getter
	public String getDisplayName() {
		//return number + "." + name + " $" + price;
		return String.format("%d.%s $%d", number, name, price);
	}
	
	public int getPrice() {
		return price;
	}
	
	public int getNumber() {
		return number;
	}
	
	public String getName() {
		return name;
	}
	
}
