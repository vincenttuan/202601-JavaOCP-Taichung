package day2;

// 雞排店
public class ChickenShopDemo {
	
	public static void main(String[] args) {
		// 今日訂單陣列
		ChickenOrder[] chickenOrders = {
				new ChickenOrder("原味", 80, 5),
				new ChickenOrder("辣味", 85, 8),
				new ChickenOrder("檸檬", 90, 3),
		}; 
		
		System.out.println("印出所有訂單");
		// 印出所有訂單
		ChickenOrder.printAll(chickenOrders);
		System.out.println("=====================");
		
		// 統計營收
		System.out.println("營收統計");
		System.out.printf("今日總營收: $%,.1f%n", ChickenOrder.getStoreTotal(chickenOrders));
		System.out.printf("平均訂單: $%,.1f%n", ChickenOrder.getAverageOrder(chickenOrders));
	}
	
}
