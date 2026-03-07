package day5.parking;

import java.text.SimpleDateFormat;
import java.util.Date;

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
		// 直接呈現 record1.getEntryTime() 內容
		System.out.printf("車牌:%s 車位:%d 進場時間:%d 費率:%d/秒%n",
				record1.getVehicle().getPlateNumber(),
				record1.getSpaceNumber(),
				record1.getEntryTime(),
				record1.getRatePerSecond());
		
		// 使用 new Date() 來格式化 record1.getEntryTime()
		System.out.printf("車牌:%s 車位:%d 進場時間:%s 費率:%d/秒%n",
				record1.getVehicle().getPlateNumber(),
				record1.getSpaceNumber(),
				new Date(record1.getEntryTime()),
				record1.getRatePerSecond());
		
		// SimpleDateFormat + new Date() 自訂格式化 record1.getEntryTime()
		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
		System.out.printf("車牌:%s 車位:%d 進場時間:%s 費率:%d/秒%n",
				record1.getVehicle().getPlateNumber(),
				record1.getSpaceNumber(),
				sdf.format(new Date(record1.getEntryTime())),
				record1.getRatePerSecond());
		
		System.out.println("-------------------------");
		
		// 多加入一筆停車紀錄
		ParkingRecord record2 = new ParkingRecord();
		record2.setVehicle(bike);
		record2.setSpaceNumber(2);
		record2.setEntryTime(System.currentTimeMillis());
		record2.setRatePerSecond(1);
		
		// 建立 ParkingRecord 陣列
		ParkingRecord[] records = {record1, record2};
		System.out.printf("全部停車紀錄:%n");
		for(ParkingRecord record : records) {
			System.out.printf("車牌:%s 車位:%d 進場時間:%s 費率:%d/秒%n",
					record.getVehicle().getPlateNumber(),
					record.getSpaceNumber(),
					sdf.format(new Date(record.getEntryTime())),
					record.getRatePerSecond());
		}
		
		
		
	}

}
