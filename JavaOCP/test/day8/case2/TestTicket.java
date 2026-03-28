package day8.case2;

public class TestTicket {
	
	public static void main(String[] args) {
		Ticket t1 = new Ticket(1305, "1A", 540);
		Ticket t2 = new Ticket(1305, "1A", 540);
		Ticket t3 = t2;
		
		System.out.println(t1);
		System.out.println(t2);
		System.out.println("t1 == t2 ? " + (t1 == t2));
		System.out.println("t3 == t2 ? " + (t3 == t2));
		
		
	}
	
}
