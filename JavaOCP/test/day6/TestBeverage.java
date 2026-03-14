package day6;

public class TestBeverage {
	public static void main(String[] args) {
		// 飲料測試 1
		Beverage beverage1 = new Beverage();
		System.out.printf("飲料測試 1\n飲料名: %s%n%n", beverage1.getName());
		
		// 飲料測試 2
		Beverage beverage2 = new Coffee(); // 多型宣告
		System.out.printf("飲料測試 2\n飲料名: %s%n%n", beverage2.getName());
		
	}
}
