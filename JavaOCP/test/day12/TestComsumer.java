package day12;

import java.util.List;
import java.util.function.Consumer;

/**
@FunctionalInterface
public interface Consumer<T> {
    void accept(T t);
}
*/
public class TestComsumer {

	public static void main(String[] args) {
		Consumer<String> welcome = (username) -> System.out.println("歡迎 " + username + " 蒞臨指導 !");
		welcome.accept("王總");
		
		Consumer<Double> tax = (price) -> System.out.println("含稅價格 : " + (price * 1.05) + " 元");
		tax.accept(100.0);
		
		Consumer<String[]> printAllNames = (names) -> {
			for(String name : names) {
				System.out.println(name);
			}
		};
		
		String[] names = {"Java", "Python", "C#"};
		printAllNames.accept(names);
		
	}

}
