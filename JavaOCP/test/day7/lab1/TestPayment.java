package day7.lab1;

public class TestPayment {
	
	public static void main(String[] args) {
		Payment payment1 = new CreditCard();
		// 付款
		System.out.println("=== 付款測試 ===");
		payment1.pay(10000);
		
		// 退款
		System.out.println("\n=== 退款測試 ===");
		payment1.refund(10000);
	}
	
}
