package day14;

import java.util.List;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class InvokeAnyDemo {
	
	public static void main(String[] args) throws Exception {
		// 牛肉麵
		// 蛋包飯
		// 水餃
		
		ExecutorService pool = Executors.newFixedThreadPool(3);
		
		Callable<String> task1 = () -> {
			Thread.sleep(new Random().nextInt(3000));
			return "牛肉麵";
		};
		
		Callable<String> task2 = () -> {
			Thread.sleep(new Random().nextInt(3000));
			return "蛋包飯";
		};
		
		Callable<String> task3 = () -> {
			Thread.sleep(new Random().nextInt(3000));
			return "水餃";
		};
		
		List<Callable<String>> tasks = List.of(task1, task2, task3);
		
		System.out.println("午餐等待中...");
		// 得到最快的餐點
		String result = pool.invokeAny(tasks);
		System.out.printf("今日午餐: %s%n", result);
		
		pool.shutdown();
		
	}
	
}








