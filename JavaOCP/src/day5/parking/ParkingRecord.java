package day5.parking;

import java.text.SimpleDateFormat;
import java.util.Date;

// 停車紀錄資訊
public class ParkingRecord {
	
	private Vehicle vehicle; // (組合)交通工具
	private int spaceNumber; // 停車格
	private long entryTime; // 進場時間
	private int ratePerSecond; // 每秒費率
	
	public ParkingRecord() {
		
	}
	
	public ParkingRecord(Vehicle vehicle, int spaceNumber, int ratePerSecond) {
		setVehicle(vehicle);
		setSpaceNumber(spaceNumber);
		setRatePerSecond(ratePerSecond);
		setEntryTime(System.currentTimeMillis()); // 直接寫入現在時間
	}
	
	// 封裝方法(getter/setter)
	public Vehicle getVehicle() {
		return vehicle;
	}
	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}
	public int getSpaceNumber() {
		return spaceNumber;
	}
	public void setSpaceNumber(int spaceNumber) {
		this.spaceNumber = spaceNumber;
	}
	public long getEntryTime() {
		return entryTime;
	}
	public void setEntryTime(long entryTime) {
		this.entryTime = entryTime;
	}
	public int getRatePerSecond() {
		return ratePerSecond;
	}
	public void setRatePerSecond(int ratePerSecond) {
		this.ratePerSecond = ratePerSecond;
	}
	
	// 商業邏輯方法
	// 計算停車秒數
	public int getParkingSeconds() {
		long now = System.currentTimeMillis(); // 取得現在時刻
		long diff = now - entryTime; // 現在時刻 - 停車時刻 (單位 ms)
		return (int)diff / 1000; // 因為 1s = 1000ms
	}
	
	// 取得並計算停車費
	public int getFee() {
		int fee = getParkingSeconds() * ratePerSecond;
		return fee;
	}
	
	// 顯示停車資訊
	public void showInfo() {
		System.out.printf("車牌：%s 停車格：%d 停車秒數：%d 秒 停車費：%d 元%n",
				this.getVehicle().getPlateNumber(),
				this.getSpaceNumber(),
				this.getParkingSeconds(),
				this.getFee());
	}
	
	// 複寫方法
	public String toString() {
		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
		return String.format("車牌:%s 車位:%d 進場時間:%s 費率:%d/秒", 
				this.getVehicle().getPlateNumber(),
				this.getSpaceNumber(),
				sdf.format(new Date(this.getEntryTime())),
				this.getRatePerSecond());
	}
	
}









