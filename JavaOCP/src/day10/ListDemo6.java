package day10;

import java.util.LinkedList;
import java.util.Queue;

public class ListDemo6 {

	public static void main(String[] args) {
		// Queue 的應用
		// FIFI -> 先進先出
		
		Queue<String> queue = new LinkedList<>();
		queue.offer("熱鍋");
		queue.offer("放油");
		queue.offer("打蛋");
		queue.offer("調味");
		queue.offer("出鍋");
		
		System.out.println("任務執行前:" + queue);
		
		while (!queue.isEmpty()) {
			String task = queue.poll();
			if(task != null) {
				System.out.println(task);
			}
		}
		
		
		System.out.println("任務執行後:" + queue);
	}

}
