package day5.parking;

import java.util.Scanner;

public class TestParkingRecord3 {
	public static void main(String[] args) {
		// 測試停車
		Car car = new Car(4, "1234-AB");
		System.out.println("準備停車 -> " + car);
		
		// 開始停車
		ParkingRecord record = new ParkingRecord(car, 1, 2);
		System.out.println("開始停車 -> " + record);
		
		// 模擬停車時間...
		Scanner scanner = new Scanner(System.in);
		System.out.println("時間計算中, 若要停止時間計算請按下任意鍵...");
		scanner.nextLine();
		
		// 顯示停車費
		System.out.println("停車費:");
		record.showInfo();
		
	}
}
