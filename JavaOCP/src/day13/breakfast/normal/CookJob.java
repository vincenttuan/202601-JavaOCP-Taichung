package day13.breakfast.normal;

import java.util.concurrent.TimeUnit;

// 廚房做餐(熱食)
public class CookJob {
	
	public void work() {
		
		for(int i=1;i<=10;i++) {
			System.out.printf("廚房做餐中: %d%n", i);
			
			// 模擬接單時間(每次做餐時間會花費 1 秒鐘)
			try {
				TimeUnit.SECONDS.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
	}
	
}
