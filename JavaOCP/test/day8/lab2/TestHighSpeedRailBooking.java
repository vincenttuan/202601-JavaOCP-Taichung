package day8.lab2;

public class TestHighSpeedRailBooking {
	public static void main(String[] args) {
		// 台中 -> 桃園
		HighSpeedRailBooking train = new HighSpeedRailBooking("台中 -> 桃園");
		
		// 建立旅客
		HighSpeedRailBooking.Passenger p1 = train.new Passenger("小明", "普通");
		HighSpeedRailBooking.Passenger p2 = train.new Passenger("小華", "白金");
		
		// 顯示旅客資訊
		p1.showInfo();
		p2.showInfo();
		
		// 訂票
		train.bookTicket(p1, "1A", 540);
		train.bookTicket(p2, "2B", 540);
		
		train.showAllTickets();
		
	}
}
