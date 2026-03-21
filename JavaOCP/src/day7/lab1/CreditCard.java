package day7.lab1;

public class CreditCard extends AbstractPayment {
	public static final double RATE = 0.03; // 手續費率(常數)
	
	@Override
	public void pay(double amount) {
		double fee = calaulateFee(amount); // 手續費
		System.out.printf("信用卡付款: %.1f 手續費: %.1f%n", amount, fee);
	}

	@Override
	public void refund(double amount) {
		System.out.printf("信用卡退款: %.1f%n", amount);
	}

	@Override
	public double calaulateFee(double amount) {
		return amount * RATE;
	}

}
