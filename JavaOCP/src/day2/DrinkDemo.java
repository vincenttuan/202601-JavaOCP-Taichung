package day2;

public class DrinkDemo {

	public static void main(String[] args) {
		DrinkOrder order1 = new DrinkOrder();
		order1.drinkName = "橘子";
		order1.price = 35;
		order1.qty = 3;
		order1.printOrder();
		
		DrinkOrder order2 = new DrinkOrder("香蕉", 25, 8);
		order2.printOrder();
		
		DrinkOrder order3 = new DrinkOrder("鳳梨", 80.0, 2);
		order3.printOrder();
		

	}

}
