package day13.ticket;

public class Main {
	public static void main(String[] args) {
		
		TicketSystem ticketSystem = new TicketSystem();
		
		Thread t1 = new Thread(new Buyer(ticketSystem), "小明");
		Thread t2 = new Thread(new Buyer(ticketSystem), "小華");
		
		t1.start();
		
		try {
			Thread.sleep(50);
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		t2.start();
		
	}
}
