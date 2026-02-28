package day4;

import day4.drink.DrinkUtil;
import day4.drink.OrderItem;

public class TestDrinkUtil {

	public static void main(String[] args) {
		System.out.println("測試資料");
		System.out.println("=================");
		
		// 輸入訂購資訊
		String input = "1, 2x3, 5x2";
		// 得到訂購單
		OrderItem[] orderItems = DrinkUtil.parseOrder(input);
		// 印出訂購單
		DrinkUtil.printOrderItems(orderItems);
 
	}

}
