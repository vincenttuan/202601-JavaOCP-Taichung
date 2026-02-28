package day4.movie;

// 訂位
public class SeatOrder {
	
	// 物件屬性
	private Seat seat; // 預定位子
	private int quantity; // 張數
	
	public SeatOrder(Seat seat, int quantity) {
		super();
		this.seat = seat;
		this.quantity = quantity;
	}

	public Seat getSeat() {
		return seat;
	}

	public int getQuantity() {
		return quantity;
	}
	
	public int getTotalPrice() {
		return seat.getPrice() * quantity; // 座位價格 x 張數
	}
	
}
