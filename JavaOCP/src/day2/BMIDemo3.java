package day2;

public class BMIDemo3 {

	public static void main(String[] args) {
		// 建立物件實體
		BMIUser user1 = new BMIUser();
		// 資料設定(設定屬性)
		user1.name = "小明";
		user1.height = 170.0;
		user1.weight = 60.0;
		// 執行邏輯(執行方法)
		user1.printBMI();
		
		BMIUser user2 = new BMIUser();
		user2.name = "小英";
		user2.height = 160.0;
		user2.weight = 45.5;
		user2.printBMI();
		
		BMIUser user3 = new BMIUser("小華", 175.5, 72.5);
		user3.printBMI();

	}

}
