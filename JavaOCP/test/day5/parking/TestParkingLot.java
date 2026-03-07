package day5.parking;

import java.util.Scanner;

//測試停車
public class TestParkingLot {

	public static void main(String[] args) {
		// 建立停車場
		ParkingLot lot = new ParkingLot(10);
		lot.showParkingLot();
		
		// 建立車
		Car car = new Car(4, "1234-AB");
		Bike bike = new Bike(false, "5678-XY");
		Car car2 = new Car(2, "1111-CC");
		
		// 停車
		lot.parking(car, 2);
		lot.parking(bike, 1);
		lot.parking(car2, 2);
		lot.showParkingLot();
		
		// 模擬取車
		Scanner scanner = new Scanner(System.in);
		System.out.print("請輸入車號:");
		String plateNumber = scanner.next();
		// 取車(移出車輛)
		lot.removeCar(plateNumber);
		lot.showParkingLot();
		
	}

}
