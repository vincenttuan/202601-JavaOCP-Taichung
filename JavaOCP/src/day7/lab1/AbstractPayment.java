package day7.lab1;

public abstract class AbstractPayment implements Payment {
	
	// 強制子類別實作此方法: 手續費計算
	public abstract double calaulateFee(double amount);
	
}
