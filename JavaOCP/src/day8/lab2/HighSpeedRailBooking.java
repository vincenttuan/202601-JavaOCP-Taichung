package day8.lab2;

public class HighSpeedRailBooking {
	
	private String trainName;
	
	public HighSpeedRailBooking(String trainName) {
		this.trainName = trainName;
	}
	
	// 一般內部類別: 旅客
	public class Passenger {
		private String name;
		private String membership; // 普通/黃金/白金
		
		public Passenger(String name, String membership) {
			this.name = name;
			this.membership = membership;
		}
		
		public void showInfo() {
			System.out.printf("旅客: %s, 等級: %s%n", name, membership);
		}
		
		public String getName() {
			return name;
		}
		
		public String getMembership() {
			return membership;
		}
		
	}
	
}
