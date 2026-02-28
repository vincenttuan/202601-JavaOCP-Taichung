package day4;

import day4.drink.Drink;

public class TestDrink {

	public static void main(String[] args) {
		System.out.println("測試資料");
		System.out.println("=================");
		
		// 建立二杯飲料
		Drink d1 = new Drink(1, "珍珠奶茶", 60);
		Drink d2 = new Drink(2, "甘蔗清茶", 50);
		
		// 印出資料
		System.out.println(d1.getDisplayName());
		System.out.println(d2.getDisplayName());
	}

}
