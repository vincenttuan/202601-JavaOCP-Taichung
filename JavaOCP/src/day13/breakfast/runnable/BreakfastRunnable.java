package day13.breakfast.runnable;

import day13.breakfast.normal.CookJob;
import day13.breakfast.normal.DrinkJob;
import day13.breakfast.normal.OrderJob;

public class BreakfastRunnable implements Runnable {
	
	private Object job;
	
	public BreakfastRunnable(Object job) {
		this.job = job;
	}
	
	@Override
	public void run() {
		
		
	}

}
