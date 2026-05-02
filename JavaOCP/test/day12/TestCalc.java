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
		
		
	}
}
