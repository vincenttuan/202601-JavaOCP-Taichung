package day13.ticket.lock;

// 購票者
public class Buyer implements Runnable {
	
	// 票務系統
	private TicketSystem ticketSystem;
	
	public Buyer(TicketSystem ticketSystem) {
		this.ticketSystem = ticketSystem;
	}

	@Override
	public void run() {
		try {
			// 買票
			ticketSystem.buy();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
}
