package day13.travel;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

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
			barrier.await(5, TimeUnit.SECONDS);
			
			// 全員到齊之後才會往下執行
			System.out.printf("%s 一起進入月台.%n", threadName);
			
		} catch (TimeoutException e) {
			System.err.printf("%s 不等大家了直接去月台%n", threadName);
		} catch (BrokenBarrierException e) {
			System.err.printf("%s 發現集合失敗, 行程取消%n", threadName);
		} catch (InterruptedException e) {
			System.err.printf("%s 執行緒被中斷%n", threadName);
		}
		
	}

}
