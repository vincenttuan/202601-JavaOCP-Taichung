package day7.lab2;

public class VIPTicket extends AbstractTicket {
	
	public static final double RATE = 0.10;
	
	public VIPTicket(String name, double price) {
		super(name, price);
	}

	@Override
	public double calculateFee(double amount) {
		return amount * RATE;
	}	
}
