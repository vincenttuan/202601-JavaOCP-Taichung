package day4.drink;

import day4.drink.Drink;
import day4.drink.OrderItem;

public class TestOrderItem2 {

	public static void main(String[] args) {
		System.out.println("測試資料");
		System.out.println("=================");
		
		// 建立二杯飲料
		Drink d1 = new Drink(1, "珍珠奶茶", 60);
		Drink d2 = new Drink(2, "甘蔗清茶", 50);
		
		// 建立訂單項目
		OrderItem oItem1 = new OrderItem(d1, 1); // 珍珠奶茶 1杯
		OrderItem oItem2 = new OrderItem(d2, 3); // 甘蔗清茶 3杯
		
		// 放到訂單陣列中
		OrderItem[] oItems = {oItem1, oItem2};
		
		// 印出訂單項目資訊(for-loop)
		for(int i=0;i<oItems.length;i++) {
			OrderItem oItem = oItems[i]; // 得到陣列中的訂單項目物件
			// 列印訂單資料
			System.out.printf("品名:%s 單價:%d 數量:%d 小計:%d%n", 
					  oItem.getDrink().getName(),
					  oItem.getDrink().getPrice(),
					  oItem.getQuantity(),
					  oItem.getTotalPrice());
		}
		System.out.println("------------------------");
		// 印出訂單項目資訊(for-each / for-in)
		for(OrderItem oItem:oItems) {
			// 列印訂單資料
			System.out.printf("品名:%s 單價:%d 數量:%d 小計:%d%n", 
					  oItem.getDrink().getName(),
					  oItem.getDrink().getPrice(),
					  oItem.getQuantity(),
					  oItem.getTotalPrice());
		} 
		
	}

}
