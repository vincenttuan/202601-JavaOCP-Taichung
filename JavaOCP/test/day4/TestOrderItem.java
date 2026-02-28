package day4;

public class TestOrderItem {

	public static void main(String[] args) {
		System.out.println("測試資料");
		System.out.println("=================");
		
		// 建立二杯飲料
		Drink d1 = new Drink(1, "珍珠奶茶", 60);
		Drink d2 = new Drink(2, "甘蔗清茶", 50);
		
		// 建立訂單項目
		OrderItem oItem1 = new OrderItem(d1, 1); // 珍珠奶茶 1杯
		OrderItem oItem2 = new OrderItem(d2, 3); // 甘蔗清茶 3杯
		
		// 印出訂單項目資訊
		// oItem1 的訂單資訊
		System.out.printf("品名:%s 單價:%d 數量:%d 小計:%d%n", 
						  oItem1.getDrink().getName(),
						  oItem1.getDrink().getPrice(),
						  oItem1.getQuantity(),
						  oItem1.getTotalPrice());
		
		// oItem2 的訂單資訊
		System.out.printf("品名:%s 單價:%d 數量:%d 小計:%d%n", 
				  		  oItem2.getDrink().getName(),
				  		  oItem2.getDrink().getPrice(),
				  		  oItem2.getQuantity(),
				  		  oItem2.getTotalPrice());
	}

}
