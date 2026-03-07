package day5.parking;

//測試停車
public class TestParkingLot {

	public static void main(String[] args) {
		// 建立停車場
		ParkingLot lot = new ParkingLot();

		// 建立車
		Car car = new Car(4, "1234-AB");
		
		// 停車
		lot.parking(car, 2);
		

	}

}
