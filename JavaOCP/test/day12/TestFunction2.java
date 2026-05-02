package day12;

import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.UnaryOperator;

/*
 * 1個參數 + 1個回傳
@FunctionalInterface
public interface Function<T,R> {
	R apply(T t);
}

 * 1個參數 + 1個回傳 且 參數與回傳型別相同 
@FunctionalInterface
public interface UnaryOperator<T> extends Function<T,T> {
	// T apply(T t);
}

 * 2個參數 + 1個回傳
@FunctionalInterface
public interface BiFunction<T,U,R> {
	R apply(T t, U u)
}

 * 2個參數 + 1個回傳 且 參數與回傳型別相同
@FunctionalInterface
public interface BinaryOperator<T> extends BiFunction<T,T,T> {
	// T apply(T t1, T t2)
}


*/
public class TestFunction2 {

	public static void main(String[] args) {
		// 計算圓面積
		Function<Double, Double> func1 = (r) -> r * r * 3.1415926;
		UnaryOperator<Double>    func2 = (r) -> r * r * 3.1415926; 
		
		double r = 10.0; // 半徑
		System.out.printf("半徑: %.1f 圓面積: %.1f%n", r, func1.apply(r));
		System.out.printf("半徑: %.1f 圓面積: %.1f%n", r, func2.apply(r));
		
		// 計算 bmi
		// 輸入:身高:170.0(Double) 體重:60.0(Double) 回傳:bmi:20.76(Double)
		BiFunction<Double, Double, Double> bmi1 = (h, w) -> w / Math.pow(h/100, 2);
		BinaryOperator<Double>             bmi2 = (h, w) -> w / Math.pow(h/100, 2); 
		
		double h = 170.0;
		double w = 60.0;
		System.out.printf("身高: %.1f 體重: %.1f bmi: %.2f%n", h, w, bmi1.apply(h, w));
		System.out.printf("身高: %.1f 體重: %.1f bmi: %.2f%n", h, w, bmi2.apply(h, w));
	}

}
