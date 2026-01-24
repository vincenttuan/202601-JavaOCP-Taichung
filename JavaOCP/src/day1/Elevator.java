package day1;

import java.util.Scanner;

public class Elevator {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.printf("請輸入目前樓層 => ");
		int current = sc.nextInt();
		boolean running = true;
		while(running) {
			
			System.out.printf("請輸入目標樓層 => ");
			int target = sc.nextInt();
			
			// 上樓
			if(current < target) {
				for(int floor = current ; floor <= target  ; floor++) {
					System.out.printf("電梯上樓目前在 %d 樓%n", floor);
				}
			}
			
			// 下樓
			if(current > target) {
				for(int floor = current ; floor >= target ; floor--) {
					System.out.printf("電梯下樓目前在 %d 樓%n", floor);
				}
			}
			
			// 同一樓
			if(current == target) {
				System.out.printf("你已在目標樓層: %d%n", target);
			}
			
			System.out.println("電梯抵達目的地");
			// 將 current 變更為 target
			current = target;
		}
		
		sc.close();
	}

}
