package day6;

public class Coffee extends Beverage {
	@Override // 方法複寫
	public String getName() {
		return "咖啡";
	}
	
	public int getCapacity() { // 容量(cc)
		return 250;
	}
}
