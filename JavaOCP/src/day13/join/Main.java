package day13.join;

public class Main {
	
	public static void main(String[] args) throws InterruptedException {
		Thread order1 = new Thread(new OrderJob(), "訂單 1");
		Thread cook1 = new Thread(new CookJob(), "做餐 1");
		
		Thread order2 = new Thread(new OrderJob(), "訂單 2");
		Thread cook2 = new Thread(new CookJob(), "做餐 2");
		
		Thread order3 = new Thread(new OrderJob(), "訂單 3");
		Thread cook3 = new Thread(new CookJob(), "做餐 3");
		
		order1.start();
		order1.join(); // 等[訂單 1]完成
		cook1.start();
		
		order2.start();
		order2.join(); // 等[訂單 2]完成
		cook2.start();
		
		order3.start();
		order3.join(); // 等[訂單 3]完成
		cook3.start();
		
	}
	
}
