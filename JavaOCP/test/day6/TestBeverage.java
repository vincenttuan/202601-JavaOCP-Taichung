package day6;

public class TestBeverage {
	public static void main(String[] args) {
		// 飲料測試 1
		Beverage beverage1 = new Beverage();
		System.out.printf("飲料測試 1\n飲料名: %s%n%n", beverage1.getName());
		
		// 飲料測試 2
		Beverage beverage2 = new Coffee(); // 多型宣告
		System.out.printf("飲料測試 2\n飲料名: %s%n%n", beverage2.getName());
		
		// 飲料測試 3
		Coffee coffee = new Coffee();
		System.out.printf("飲料測試 3\n飲料名: %s 容量: %dcc%n%n", 
						coffee.getName(), 
						coffee.getCapacity());
		
		// 飲料測試 4
		Beverage beverage4 = new Coffee();
		System.out.printf("飲料測試 4\n飲料名: %s 容量: %dcc%n%n", 
						beverage4.getName(), 
						((Coffee)beverage4).getCapacity());
		
	}
}



