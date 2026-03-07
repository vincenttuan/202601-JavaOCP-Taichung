package day5.parking;

// 機車
public class Bike extends Vehicle {
	private boolean isElectric; // 是否是電動車
	
	public Bike() {
		
	}
	
	public Bike(boolean isElectric, String plateNumber) {
		this.setElectric(isElectric);
		this.setPlateNumber(plateNumber);
	}
	
	public boolean isElectric() {
		return isElectric;
	}

	public void setElectric(boolean isElectric) {
		this.isElectric = isElectric;
	}
	
	
}
