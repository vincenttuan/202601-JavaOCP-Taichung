package day5.parking;

//測試停車
public class TestParkingLot {

	public static void main(String[] args) {
		// 建立停車場
		ParkingLot lot = new ParkingLot(10);

		// 建立車
		Car car = new Car(4, "1234-AB");
		Bike bike = new Bike(false, "5678-XY");
		Car car2 = new Car(2, "1111-CC");
		
		// 停車
		lot.parking(car, 2);
		lot.parking(bike, 1);
		lot.parking(car2, 2);
	}

}
