package day13.ticket.sync;

public class TicketSystem {
	
	private int tickets = 1; // 只有 1 張票
	
	public synchronized void buy() throws InterruptedException {
		String threadName = Thread.currentThread().getName();
		
		if(tickets <= 0) {
			System.out.printf("%s 沒看見票, 離開...%n", threadName);
			return;
		}
		
		System.out.printf("%s 看見有 %d 張票, 準備購買...%n", threadName, tickets);
			
		// 研擬買票程序會花費的時間延遲
		Thread.sleep(100);
			
		// 買票
		tickets--;
		
		System.out.printf("%s 成功買到 1 張票!%n", threadName);
	}
	
}
