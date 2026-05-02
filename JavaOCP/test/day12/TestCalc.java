package day12;

public class TestCalc {
	public static void main(String[] args) {
		// 加法
		// 1. 透過匿名內部類別來實現 Calc
		Calc calc1 = new Calc() {
			@Override
			public double compute(double x, double y) {
				return x + y;
			}
		};
		System.out.println(calc1.compute(20.5, 10));
		
		// 2. 使用 lambda 語法
		Calc calc2 = (double x, double y) -> x + y;
		System.out.println(calc2.compute(20.5, 10));
		
		Calc calc3 = (x, y) -> x + y;
		System.out.println(calc3.compute(20.5, 10));
		
		Calc calc4 = (double x, double y) -> {
			double result = x + y;
			return result;
		};
		System.out.println(calc4.compute(20.5, 10));
		
	}
}
