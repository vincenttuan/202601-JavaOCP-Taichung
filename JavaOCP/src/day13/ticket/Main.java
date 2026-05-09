package day13.ticket;

public class Main {
	public static void main(String[] args) {
		
		TicketSystem ticketSystem = new TicketSystem();
		
		Thread t1 = new Thread(new Buyer(ticketSystem), "小明");
		
		t1.start();
		
	}
}
