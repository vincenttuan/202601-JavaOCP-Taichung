package day13.breakfast.normal;

import java.util.concurrent.TimeUnit;

// 櫃台接單
public class OrderJob {
	
	public void work() {
		
		for(int i=1;i<=10;i++) {
			System.out.printf("櫃台接單中: %d%n", i);
			
			// 模擬接單時間(每次接單時間會花費 1 秒鐘)
			try {
				TimeUnit.SECONDS.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
	}
	
}
