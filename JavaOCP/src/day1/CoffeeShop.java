package day1;

import java.util.Scanner;

public class CoffeeShop {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		// 咖啡選擇
		System.out.println("請選擇咖啡");
		System.out.println("1. 熱咖啡");
		System.out.println("2. 冰咖啡");
		System.out.print("請輸入選項 => ");
		int choice = sc.nextInt();
		
		// 甜度
		System.out.println("\n請選擇甜度");
		System.out.println("1. 無糖");
		System.out.println("2. 微糖");
		System.out.println("3. 半糖");
		System.out.println("4. 全糖");
		System.out.print("請輸入選項 => ");
		int sugar = sc.nextInt();
		
		// 冰量
		System.out.println("\n請選擇冰量");
		System.out.println("1. 去冰");
		System.out.println("2. 微冰");
		System.out.println("3. 少冰");
		System.out.println("4. 正常冰");
		System.out.print("請輸入選項 => ");
		int ice = sc.nextInt();
		
		// 印出訂單
		System.out.println("\n你的咖啡訂單");
		switch (choice) {
			case 1:
				System.out.println("熱咖啡");
				break;
			case 2:
				System.out.println("冰咖啡");
				break;
		}
		
		switch(sugar) {
			case 1:
				System.out.println("無糖");
				break;
			case 2:
				System.out.println("微糖");
				break;
			case 3:
				System.out.println("半糖");
				break;
			case 4:
				System.out.println("全糖");
				break;
		}
		

	}

}
