package day7.lab2;

public class StudentTicket extends AbstractTicket {
	
	public static final double RATE = 0.01;
	
	public StudentTicket(String name, double price) {
		super(name, price);
	}

	@Override
	public double calculateFee(double amount) {
		return amount * RATE;
	}	
}
