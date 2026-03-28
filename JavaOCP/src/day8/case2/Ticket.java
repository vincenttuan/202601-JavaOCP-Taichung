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
	
	@Override
	public boolean equals(Object obj) {
		// 1. 自己比自己
		if(this == obj) return true;
		
		// 2. null 檢查
		if(obj == null) return false;
		
		// 3. 型別檢查
		if(getClass() != obj.getClass()) return false;
		
		// 4. 轉型
		Ticket other = (Ticket)obj;
		
		// 5. 比內容
		// 相同 trainNo 與 seat 才視為相等
		return this.trainNo == other.trainNo &&
				this.seat.equals(other.seat);
				
	}
	
	@Override
	public int hashCode() {
		return 7 * 31 * trainNo + seat.hashCode();
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
