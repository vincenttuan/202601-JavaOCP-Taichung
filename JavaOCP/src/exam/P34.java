package exam;

enum Status {
	銅牌(1000), 銀牌(5000), 金牌(10000);
	private int cash;
	private Status(int cash) {
		this.cash = cash;
	}
	public int getCash() {
		return cash;
	}
}

public class P34 {
	public static void main(String[] args) {
		Status sliver = Status.銀牌;
		System.out.println(sliver.getCash());
		
	}
}
