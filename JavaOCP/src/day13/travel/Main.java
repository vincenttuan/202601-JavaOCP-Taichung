package day13.travel;

import java.util.concurrent.CyclicBarrier;

public class Main {
	public static void main(String[] args) {
		// 到達之後要做的事 
		Runnable barrierAction = () -> {
			System.out.println("一起去吃午餐...");
		};
		// n 個人都到齊之後才出發
		int parties = 3;
		CyclicBarrier barrier = new CyclicBarrier(parties, barrierAction);
		
		Thread t1 = new Thread(new Traveler(barrier), "小明");
		Thread t2 = new Thread(new Traveler(barrier), "小華");
		Thread t3 = new Thread(new Traveler(barrier), "小英");
		Thread t4 = new Thread(new Traveler(barrier), "小美");
		
		t1.start();
		t2.start();
		t3.start();
		t4.start();
		
	}
}
