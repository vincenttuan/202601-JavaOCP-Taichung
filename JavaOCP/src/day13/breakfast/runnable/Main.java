package day13.breakfast.runnable;

import day13.breakfast.normal.CookJob;
import day13.breakfast.normal.DrinkJob;
import day13.breakfast.normal.OrderJob;

public class Main {
	
	public static void main(String[] args) {
		// 建立 3 個 Runnable (可以被執行緒執行的任務)
		Runnable r1 = new BreakfastRunnable(new OrderJob());
		Runnable r2 = new BreakfastRunnable(new CookJob());
		Runnable r3 = new BreakfastRunnable(new DrinkJob());
		
		// 建立執行緒
		Thread t1 = new Thread(r1, "櫃台員工");
		Thread t2 = new Thread(r2, "熱食員工");
		Thread t3 = new Thread(r3, "飲料員工");
		
		// 啟動
		t1.start();
		t2.start();
		t3.start();
	}
	
}
