package day7.lab2;

public class TestTicket {

	public static void main(String[] args) {
		Ticket vip = new VIPTicket("VIP票", 5000);
		Ticket normal = new NormalTicket("一般票", 2000);
		Ticket student = new StudentTicket("學生票", 1000);
		
		// 假設數量=2
		int qty = 2;
		
		System.out.println("=== 訂票測試 ===");
		System.out.printf("VIP訂票: $%,.1f%n", vip.book(qty));
		System.out.printf("一般訂票: $%,.1f%n", normal.book(qty));
		System.out.printf("學生訂票: $%,.1f%n", student.book(qty));
		
		System.out.println("\n=== 退票測試 ===");
		
		System.out.printf("VIP退票: $%,.1f%n", vip.refund(qty));
		System.out.printf("一般退票: $%,.1f%n", normal.refund(qty));
		System.out.printf("學生退票: $%,.1f%n", student.refund(qty));
		

	}

}
