package day13.join;

public class CookJob implements Runnable {

	@Override
	public void run() {
		String threadName = Thread.currentThread().getName();
		// 模擬花費的時間
		try {
			Thread.sleep(100); // 1000ms = 1s
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.printf("[%s]廚房做餐%n", threadName);
	}
	
}
