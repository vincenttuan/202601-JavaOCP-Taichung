package day7.case3;

public class MovieTicket implements Ticket {
	private double price;
	private int qty;
	
	public MovieTicket(double price, int qty) {
		this.price = price;
		this.qty = qty;
	}
	
	@Override
	public double book() {
		return (price * qty) + calculateFee();
	}

	@Override
	public double refund() {
		return (price * qty);
	}

	@Override
	public double calculateFee() {
		return (price * qty) * 0.01;
	}

	@Override
	public double getPrice() {
		return price;
	}

}
