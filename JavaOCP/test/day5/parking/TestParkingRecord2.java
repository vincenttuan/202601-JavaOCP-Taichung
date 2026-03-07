package day5.parking;

import java.util.stream.Stream;

public class TestParkingRecord2 {

	public static void main(String[] args) {
		// 優化後測試 ParkingRecord
		Car car = new Car(4, "1234-AB");
		Bike bike = new Bike(true, "5678-XY");
		
		System.out.println(car);
		System.out.println(bike);
		
		Vehicle[] vehicles = {car, bike};
		for(Vehicle vehicle : vehicles) {
			System.out.println(vehicle);
		}
		
		Stream.of(vehicles).forEach(System.out::println);
		Stream.of(car, bike).forEach(System.out::println);
		
		ParkingRecord record1 = new ParkingRecord(car, 1, 2);
		ParkingRecord record2 = new ParkingRecord(bike, 2, 1);
		
		
		
	}

}
