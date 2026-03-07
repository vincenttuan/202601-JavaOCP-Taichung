package day5.parking;

public class TestParkingRecord {

	public static void main(String[] args) {
		// 測試 ParkingRecord
		Car car = new Car();
		car.setSeats(4); // 方法封裝測試
		car.setPlateNumber("1234-AB"); // 繼承+方法封裝測試
		
		Bike bike = new Bike();
		bike.setElectric(true); // 方法封裝測試
		bike.setPlateNumber("5678-XY"); // 繼承+方法封裝測試
		
		// 停車紀錄
		ParkingRecord record1 = new ParkingRecord();
		record1.setVehicle(car); // 設定交通工具
		record1.setSpaceNumber(1); // 車位
		record1.setEntryTime(System.currentTimeMillis()); // 現在時刻(單位微渺, 1000微秒 = 1 秒)
		record1.setRatePerSecond(2); // 2元/秒
		
		System.out.printf("停車紀錄:%n");
		System.out.printf("車牌: %s 車位: %d 進場時間:%d 費率: %d/秒%n",
							record1.getVehicle().getPlateNumber(),
							record1.getSpaceNumber(),
							record1.getEntryTime(),
							record1.getRatePerSecond());
		
		
	}

}
