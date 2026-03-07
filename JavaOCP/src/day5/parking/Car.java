package day5.parking;

// 汽車
public class Car extends Vehicle {
	private int seats; // 座位數
	
	public Car() {
		
	}
	
	public Car(int seats, String plateNumber) {
		this.setSeats(seats);
		this.setPlateNumber(plateNumber);
	}
	
	public int getSeats() {
		return seats;
	}

	public void setSeats(int seats) {
		this.seats = seats;
	}
	
	public String toString() {
		return String.format("汽車車牌: %s 座位數: %d%n", 
				this.getPlateNumber(), this.getSeats());
	}
	
}
