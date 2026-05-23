package day14;

import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class InvokeAllDemo {
	
	public static void main(String[] args) throws Exception {
		// 牛肉麵要端上桌
		// 1.牛肉選好
		// 2.麵條要煮好
		// 3.湯要盛好
		
		ExecutorService pool = Executors.newFixedThreadPool(3);
		
		Callable<String> task1 = () -> {
			Thread.sleep(3000);
			return "牛肉放好";
		};
		
		Callable<String> task2 = () -> {
			Thread.sleep(5000);
			return "麵條煮好";
		};
		
		Callable<String> task3 = () -> {
			Thread.sleep(1000);
			return "湯頭盛好";
		};
		
		List<Callable<String>> tasks = List.of(task1, task2, task3);
		
		System.out.println("牛肉麵等待中...");
		// 等待全部完成
		List<Future<String>> results = pool.invokeAll(tasks);
		
		for(Future<String> future : results) {
			System.out.println(future.get());
		}
		System.out.println("牛肉麵煮好了");
		
		pool.shutdown();
		
	}
	
}








