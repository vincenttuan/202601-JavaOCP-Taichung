package day12;

// Calc 計算器
@FunctionalInterface // 只能有一個未實現方法
public interface Calc {
	
	double compute(double x, double y); // compute 計算邏輯 (未實現方法)
	String toString(); // 這是 Object.java 一定會實現的方法, 所以不列入未實現方法中
	
	default void copyright() {
		System.out.println("版權所有");
	}
	
	static void welcome() {
		System.out.println("歡迎使用");
	}
}
