package day13.join;

public class OrderJob implements Runnable {

	@Override
	public void run() {
		String threadName = Thread.currentThread().getName(); 
		System.out.printf("[%s]櫃台接單%n", threadName);
	}
	
}
