package day7.lab1;

public class TestPayment {
	
	public static void main(String[] args) {
		Payment payment1 = new CreditCard();
		// 付款
		payment1.pay(10000);
		// 退款
		payment1.refund(10000);
	}
	
}
