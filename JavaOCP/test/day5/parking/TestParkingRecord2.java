package day5.parking;

public class TestParkingRecord2 {

	public static void main(String[] args) {
		// 優化後測試 ParkingRecord
		Car car = new Car(4, "1234-AB");
		Bike bike = new Bike(true, "5678-XY");
		
		System.out.println(car);
		System.out.println(bike);
		
	}

}
