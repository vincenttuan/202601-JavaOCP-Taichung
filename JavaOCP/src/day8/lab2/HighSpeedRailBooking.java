package day8.lab2;

public class HighSpeedRailBooking {
	
	private String trainName;
	private Ticket[] tickets = new Ticket[5]; // 票務預設 5 張
	private int ticketCount = 0; // 目前已訂票數量
	
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
	
	// 靜態內部類別: 票務
	public static class Ticket {
		private String seat;
		private int price;
		private String passengerName;
		
		public Ticket(String seat, int price, String passengerName) {
			this.seat = seat;
			this.price = price;
			this.passengerName = passengerName;
		}

		public String getSeat() {
			return seat;
		}

		public int getPrice() {
			return price;
		}

		public String getPassengerName() {
			return passengerName;
		}
		
	}
	
	// 訂票方法
	public void bookTicket(Passenger passenger, String seat, int price) {
		if(ticketCount < tickets.length) {
			tickets[ticketCount++] = new Ticket(seat, price, passenger.getName());
			System.out.printf("%s 訂票成功, 座位: %s,  價格: %d%n",
					passenger.getClass(), seat, price);
		} else {
			System.out.println("訂票已滿, 無法訂票");
		}
	}
	
	// 顯示所有訂票紀錄
	public void showAllTickets() {
		System.out.printf("=== %s 所有訂票紀錄 ===%n", trainName);
		for(Ticket ticket : tickets) {
			System.out.printf("座位: %s, 旅客: %s, 價格: %d%n", 
					ticket.getSeat(), ticket.getPassengerName(), ticket.getPrice());
		}
	}
	
}









