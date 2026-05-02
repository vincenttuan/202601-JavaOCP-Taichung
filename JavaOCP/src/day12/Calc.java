package day12;

// Calc 計算器
@FunctionalInterface
public interface Calc {
	double compute(double x, double y); // compute 計算邏輯
	
	default void copyright() {
		System.out.println("版權所有");
	}
	
	static void welcome() {
		System.out.println("歡迎使用");
	}
}
