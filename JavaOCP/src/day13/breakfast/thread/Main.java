package day13.breakfast.thread;

public class Main {

	public static void main(String[] args) {
		// 可以用多型宣告
		Thread t1 = new OrderJob(); 
		Thread t2 = new CookJob();
		Thread t3 = new DrinkJob();
		
		t1.start();
		t2.start();
		t3.start();
		

	}

}
