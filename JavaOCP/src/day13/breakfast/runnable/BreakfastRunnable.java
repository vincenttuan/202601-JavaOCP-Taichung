package day13.breakfast.runnable;

import day13.breakfast.normal.Job;

public class BreakfastRunnable implements Runnable {
	
	private Job job;
	
	public BreakfastRunnable(Job job) {
		this.job = job;
	}
	
	@Override
	public void run() {
		job.work();
	}

}
