package day7.lab2;

public class NormalTicket extends AbstractTicket {
	
	public static final double RATE = 0.05;
	
	public NormalTicket(String name, double price) {
		super(name, price);
	}

	@Override
	public double calculateFee(double amount) {
		return amount * RATE;
	}	
}
