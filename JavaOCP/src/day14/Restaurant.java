package day14;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * 一家餐廳做外賣平台
 * 每秒鐘會近來幾百幾千張訂單
 * 每張訂單
 * 1.廚師處理
 * 2.製作餐點
 * 3.完成出餐
 * 
 * 系統必須
 * 1.同時處理多筆訂單
 * 2.不可以當機
 * 3.不可以吃光 CPU
 * 4.不可以 memory 爆炸
 * */
public class Restaurant {

	public static void main(String[] args) throws Exception {
		// 建立一個固定大小的 thread pool
		// 代表只有 10 條執行緒(廚師)
		ExecutorService pool = Executors.newFixedThreadPool(10);
		
		// 模擬 100 張訂單
		for(int i=1;i<=100;i++) {
			final int orderId = i;
			pool.submit(() -> {
				// 執行緒名稱(廚師名)
				String tName = Thread.currentThread().getName();
				
				// 1.廚師處理訂單
				System.out.printf("%s 處理訂單: %d%n", tName, orderId);
				
				// 2.廚師製作餐點
				try {
					System.out.printf("%s 製作訂單: %d 的餐點中... %n", tName, orderId);
					Thread.sleep(new Random().nextInt(3000)); // 模擬花費時間
				} catch (Exception e) {
					// TODO: handle exception
				}
				
				// 3.廚師完成訂單
				System.out.printf("%s 完成訂單: %d%n", tName, orderId);
			});
		}
		
		// 不再接受新任務(訂單)
		pool.shutdown();
		
		// 每 10 秒鐘監測一次訂單狀態
		while(true) {
			boolean finished = pool.awaitTermination(10, TimeUnit.SECONDS);
			if(finished) {
				System.err.println("完成所有訂單, 餐廳打烊");
				break;
			} else {
				System.err.println("還有訂單未完成");
			}
		}
		
	}

}
