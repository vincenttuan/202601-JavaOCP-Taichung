package day13.join;

public class CookJob implements Runnable {

	@Override
	public void run() {
		String threadName = Thread.currentThread().getName(); 
		System.out.printf("[%s]廚房做餐%n", threadName);
	}
	
}
