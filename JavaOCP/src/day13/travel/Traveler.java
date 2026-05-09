package day13.travel;

public class Traveler implements Runnable {

	@Override
	public void run() {
		
		String threadName = Thread.currentThread().getName();
		
		System.out.printf("%s 出發去台中高鐵站...%n", threadName);
		
		try {
			// 模擬每個人到達時間的不同
			Thread.sleep((int)(Math.random() * 3000));
			
			System.out.printf("%s 到達車站.");
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		System.out.println("一起進入月台");
		
	}

}
