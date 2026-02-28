package day4;

public class TestDrinkMenu {

	public static void main(String[] args) {
		System.out.println("測試資料");
		System.out.println("=================");
		
		System.out.printf("%d 號飲料 => %s%n", 1, DrinkMenu.findByNumber(1).getName());
		System.out.printf("%d 號飲料 => %s%n", 3, DrinkMenu.findByNumber(3).getName());
		
		System.out.println("飲料 MENU:");
		String[] menu = DrinkMenu.getFullMenu();
		for(String menuItem : menu) {
			System.out.println(menuItem);
		}
	}

}
