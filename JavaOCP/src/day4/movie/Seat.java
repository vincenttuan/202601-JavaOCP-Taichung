package day4.movie;

// 單一座位
public class Seat {
	
	// 物件屬性
	private Hall hall; // 所屬電影廳
	private int row;   // 4 -> 第4排
	private int price; // 價格/張
	
	public Seat(Hall hall, int row, int price) {
		super();
		this.hall = hall;
		this.row = row;
		this.price = price;
	}

	public Hall getHall() {
		return hall;
	}

	public int getRow() {
		return row;
	}

	public int getPrice() {
		return price;
	}
	
	public String displayName() {
		return String.format("%s %s %d排 $%d", 
							hall.getMovie().getTitle(),
							hall.getName(),
							row,
							price);
	}
	
}
