package day2;

public class ChickenOrder {
	
	private String flavor; // 口味
	private double price; // 單價
	private int pieces; // 雞排塊/片數
	
	public ChickenOrder(String flavor, double price, int pieces) {
		this.flavor = flavor;
		this.price = price;
		this.pieces = pieces;
	}
	
	// 印出訂單
	public void printOrder() {
		double total = getTotal();
		System.out.printf("雞排訂單: %s%n", flavor);
		System.out.printf("單價: $%.1f 塊數: %d%n", price, pieces);
		System.out.printf("總額: $%.1f%n", total);
	}
	
	// 回傳總金額
	public double getTotal() {
		double total = price * pieces;
		return total;
	}
	
	// ------------------------------------------------------------
	// 共用方法
	// static 方法 1 : 整天總營收
	public static double getStoreTotal(ChickenOrder[] orders) {
		double total = 0;
		for(int i=0;i<orders.length;i++) {
			total += orders[i].getTotal();
		}
		return total;
	}
	
	// static 方法 2 : 平均每筆訂單
	public static double getAverageOrder(ChickenOrder[] orders) {
		double total = getStoreTotal(orders); // 整天總營收
		double avg = total / (double)orders.length;
		return avg;
	}
	
}















