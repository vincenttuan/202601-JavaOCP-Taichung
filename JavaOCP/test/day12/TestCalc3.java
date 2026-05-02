package day12;

public class TestCalc3 {

	public static void main(String[] args) {
		Calc ca = MathUtil::add;
		System.out.println(ca.compute(20.5, 10));
		ca.copyright(); // 透過物件變數 ca 調用
		
		Calc.welcome(); // 直接使用 Calc 類別調用

	}

}
