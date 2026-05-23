package day14;

import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ScheduleDemo {

	public static void main(String[] args) {
		// 透過 Schedule 來模擬送餐
		ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(2);
		
		System.out.println("開始製作餐點");
		
		Runnable runnable = () -> {
			System.out.println("通知外送員送餐: " + new Date());
		};
		
		// 2 秒後開始執行
		//scheduler.schedule(runnable, 2, TimeUnit.SECONDS); // 只執行一次任務
		// 0 -> 立即執行, 3 -> 之後每 3 秒執行任務一次
		scheduler.scheduleAtFixedRate(runnable, 0, 3, TimeUnit.SECONDS);
		
		System.out.println("主程式繼續執行...");

	}

}
