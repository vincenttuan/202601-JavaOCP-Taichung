package day7.lab2;


public abstract class AbstractTicket implements Ticket {
	
	protected String name;
	protected double price;
	
	public AbstractTicket(String name, double price) {
		this.name = name;
		this.price = price;
	}
	
	@Override
	public double book(int qty) {
		double amount = this.price * qty;
		double fee = calculateFee(amount);
		double total = amount + fee;
		return total;
	}
	@Override
	public double refund(int qty) {
		double total = this.price * qty;
		return total;
	}
	
}
