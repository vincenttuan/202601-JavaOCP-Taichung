package day13.travel;

import java.util.concurrent.CyclicBarrier;

public class Traveler implements Runnable {
	
	private CyclicBarrier barrier;
	
	public Traveler(CyclicBarrier barrier) {
		this.barrier = barrier;
	}
	
	@Override
	public void run() {
		
		String threadName = Thread.currentThread().getName();
		
		System.out.printf("%s 出發去台中高鐵站...%n", threadName);
		
		try {
			// 模擬每個人到達時間的不同
			Thread.sleep((int)(Math.random() * 3000));
			
			System.out.printf("%s 到達車站.%n", threadName);
			
			// 等待其他人都到齊
			barrier.wait();
			
			// 全員到齊之後才會往下執行
			System.out.println("一起進入月台");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
