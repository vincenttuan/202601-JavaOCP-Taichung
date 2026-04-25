package day11;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Exception6 {

	public static void main(String[] args) {
		int ans = 7;
		Scanner scanner = new Scanner(System.in);
		System.out.print("請猜數字數字(1~9):");
		
		try {
			int guess = scanner.nextInt();
			if(guess == ans) {
				System.out.println("猜對了");
			} else {
				System.out.println("猜錯了");
			}
		} catch (InputMismatchException e) {
			System.out.println("輸入錯誤");
		} catch (Exception e) {
			System.out.println("其他錯誤:" + e.getMessage());
			return;
		} finally {
			System.out.println("遊戲結束");
			scanner.close(); // 關閉通常都是一定要被執行的
		}
		
	}

}
