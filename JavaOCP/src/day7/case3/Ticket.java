package day7.case3;

// Ticket = 三種能力的組合
public interface Ticket extends Bookable, Refundable, FeeCalculate {
	double getPrice();
	int getQty();
	
	// java 8 透過 default 關鍵子可以在 interface 中提供有實作的方法
	default void printInfo() {
		System.out.printf("票價: %,.1f%n", getPrice());
		System.out.printf("數量: %d%n", getQty());
		System.out.printf("手續費: %,.1f%n", calculateFee());
		System.out.printf("訂票: %,.1f%n", book());
		System.out.println("===========");
		System.out.printf("退票: %,.1f%n", refund());
	}
	
}
