package day13.join;

public class Main {
	
	public static void main(String[] args) {
		Thread order1 = new Thread(new OrderJob(), "訂單 1");
		Thread cook1 = new Thread(new OrderJob(), "做餐 1");
		
		order1.start();
		cook1.start();
		
		
	}
	
}
