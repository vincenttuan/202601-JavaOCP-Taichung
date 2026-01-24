package day1;

import java.util.Scanner;
import java.util.Random;

public class GuessNumber {
	
	public static void main(String[] args) {
		Random random = new Random();
		int ans = random.nextInt(99) + 1;  // 答案 (1~99)
		int min = 0;   // 最小值
		int max = 100; // 最大值
		Scanner sc = new Scanner(System.in);
		
		do {
			// User guess
			System.out.printf("使用者請在 %d ~ %d 之間猜一個數字 => ", min, max);
			int userGuess = sc.nextInt(); // 取得使用者所猜的數字
			// 判斷使用者所猜的數字
			if(userGuess < ans) {
				min = userGuess;
			} else if(userGuess > ans) {
				max = userGuess;
			} else {
				System.out.printf("使用者答對了 => %d%n", ans);
				break; // 離開迴圈
			}
			
			// PC guess
			int pcGuess = random.nextInt(max - min - 1) + 1 + min;
			System.out.printf("電腦請在 %d ~ %d 之間猜一個數字 => %d%n", min, max, pcGuess);
			// 判斷 PC 所猜的數字
			if(pcGuess < ans) {
				min = pcGuess;
			} else if(pcGuess > ans) {
				max = pcGuess;
			} else {
				System.out.printf("電腦答對了 => %d%n", ans);
				break; // 離開迴圈
			}
			
		} while (true);
		
		sc.close(); // 關閉 sc
	}
}
