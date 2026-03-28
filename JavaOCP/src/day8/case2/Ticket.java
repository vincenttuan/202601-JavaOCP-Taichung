package day8.case2;

public class Ticket {
	private int trainNo;
	private String seat;
	private int price;
	
	public Ticket(int trainNo, String seat, int price) {
		this.trainNo = trainNo;
		this.seat = seat;
		this.price = price;
	}

	public int getTrainNo() {
		return trainNo;
	}

	public String getSeat() {
		return seat;
	}

	public int getPrice() {
		return price;
	}

	@Override
	public String toString() {
		return "Ticket [trainNo=" + trainNo + ", seat=" + seat + ", price=" + price + "]";
	}
	
	
}
