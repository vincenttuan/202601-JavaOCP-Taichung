package day4;

// 飲料選單
public class DrinkMenu {
	
	// 飲料單資料
	private static final Drink[] MENU = {
			new Drink(1, "珍珠奶茶", 60),
			new Drink(2, "甘蔗清茶", 50),
			new Drink(3, "冬瓜茶", 30),
			new Drink(4, "檸檬茶", 35),
			new Drink(5, "鮮果茶", 45),
			new Drink(6, "仙草凍", 55)
	};
	
	// findByNumber() 根據編號來查找飲料
	public static Drink findByNumber(int number) {
		for(Drink drink : MENU) { // 輪詢 MENU
			if(drink.getNumber() == number) { // 比對飲料號碼
				return drink; // 找到編號的飲料, 並將飲料回傳
			}
		}
		return null; // 找無該編號的飲料
	}
	
	// getFullMenu() 完整的飲料清單
	
	
}
