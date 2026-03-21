package day7.case3;

public class TestTicket {

	public static void main(String[] args) {
		Ticket ticket = new MovieTicket(200, 5);
		System.out.printf("票價: %,.1f%n", ticket.getPrice());
		System.out.printf("數量: %d%n", ((MovieTicket)ticket).getQty());
		System.out.printf("手續費: %,.1f%n", ticket.calculateFee());
		System.out.printf("訂票: %,.1f%n", ticket.book());
		System.out.println("===========");
		System.out.printf("退票: %,.1f%n", ticket.refund());
	}

}
