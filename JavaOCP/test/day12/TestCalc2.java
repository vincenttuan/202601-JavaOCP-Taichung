package day12;

public class TestCalc2 {

	public static void main(String[] args) {
		// Lambda
		Calc calc1 = (x, y) -> x + y;
		System.out.println(calc1.compute(20.5, 10));
		
		// Lambda + :: (方法參考)
		Calc calc2 = MathUtil::add;
		System.out.println(calc2.compute(20.5, 10));

	}

}
