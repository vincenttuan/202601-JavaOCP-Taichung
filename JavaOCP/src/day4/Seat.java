package day4;

// 單一座位
public class Seat {
	
	// 物件屬性
	private Hall hall; // 所屬電影廳
	private int[] rowCol; // x排y號, 例如:[4, 5] 第4排第5號
	private int price; // 價格/張
	
	public Seat(Hall hall, int[] rowCol, int price) {
		super();
		this.hall = hall;
		this.rowCol = rowCol;
		this.price = price;
	}

	public Hall getHall() {
		return hall;
	}

	public int[] getRowCol() {
		return rowCol;
	}

	public int getPrice() {
		return price;
	}
	
}
