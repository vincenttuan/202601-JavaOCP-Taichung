package day1;

import java.util.Scanner;

public class GuessNumber {
	
	public static void main(String[] args) {
		int ans = 86;  // 答案
		int min = 0;   // 最小值
		int max = 100; // 最大值
		Scanner sc = new Scanner(System.in);
		
		do {
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
			
		} while (true);
		
		sc.close(); // 關閉 sc
	}
}
