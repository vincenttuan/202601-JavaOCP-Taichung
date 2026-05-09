package day13.breakfast.runnable;

import java.util.List;

import day13.breakfast.normal.CookJob;
import day13.breakfast.normal.DrinkJob;
import day13.breakfast.normal.OrderJob;

public class Main2 {
	
	public static void main(String[] args) {
		// 建立所有 Runnable (可以被執行緒執行的任務)
		List<Runnable> jobs = List.of(
				new BreakfastRunnable(new OrderJob()),
				new BreakfastRunnable(new CookJob()),
				new BreakfastRunnable(new DrinkJob())
		);
		
		// 員工名稱
		List<String> names = List.of("櫃台員工", "熱食員工", "飲料員工");
		
		// 建立並啟動 Thread
		for(int i=0;i<jobs.size();i++) {
			Thread t = new Thread(jobs.get(i), names.get(i));
			t.start();
		}
				
		
	}
	
}
