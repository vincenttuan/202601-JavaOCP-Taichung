package day13.breakfast.thread;

public class Main {

	public static void main(String[] args) {
		// 可以用多型宣告
		Thread t1 = new OrderJob(); 
		Thread t2 = new CookJob();
		Thread t3 = new DrinkJob();
		
		// 設定 Thread 名
		t1.setName("order");
		t2.setName("cook");
		t3.setName("drink");
		
		// 啟動
		t1.start();
		t2.start();
		t3.start();
		

	}

}
