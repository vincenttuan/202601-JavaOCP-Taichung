package day7.case3;

// Ticket = 三種能力的組合
public interface Ticket extends Bookable, Refundable, FeeCalculate {
	double getPrice();
	int getQty();
}
