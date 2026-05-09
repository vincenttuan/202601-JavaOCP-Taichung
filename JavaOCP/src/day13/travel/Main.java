package day13.travel;

import java.util.concurrent.CyclicBarrier;

public class Main {
	public static void main(String[] args) {
		// 3 個人都到齊之後才出發
		int parties = 3;
		CyclicBarrier barrier = new CyclicBarrier(parties);
		
		Thread t1 = new Thread(new Traveler(barrier), "小明");
		Thread t2 = new Thread(new Traveler(barrier), "小華");
		Thread t3 = new Thread(new Traveler(barrier), "小英");
		
		t1.start();
		t2.start();
		t3.start();
		
	}
}
