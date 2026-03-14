package day6;

public class TestPayment {
	public static void main(String[] args) {
		Payment payment = new Payment();
		payment.submit(100);
		payment.submit(200, "Line-Pay");
		payment.submit(300, "0000-1111-2222-3333", 586);
		payment.submit();
	}
}
