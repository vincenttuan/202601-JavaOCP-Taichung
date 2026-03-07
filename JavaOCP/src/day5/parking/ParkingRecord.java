package day5.parking;

// 停車紀錄資訊
public class ParkingRecord {
	
	private Vehicle vehicle; // (組合)交通工具
	private int spaceNumber; // 停車格
	private long entryTime; // 進場時間
	private int ratePerSecond; // 每秒費率
	
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
	
}
