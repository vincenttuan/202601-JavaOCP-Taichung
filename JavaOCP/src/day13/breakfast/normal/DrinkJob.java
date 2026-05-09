package day13.breakfast.normal;

import java.util.concurrent.TimeUnit;

// 飲料區做飲料
public class DrinkJob implements Job {
	
	public void work() {
		String threadName = Thread.currentThread().getName();
		for(int i=1;i<=10;i++) {
			System.out.printf("[%s]飲料製作中: %d%n", threadName, i);
			
			// 模擬飲料製作時間(每次飲料製作時間會花費 1 秒鐘)
			try {
				TimeUnit.SECONDS.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
	}
	
}
