package day12;

import java.util.List;
import java.util.function.Consumer;

/**
 * Consumer 消費參數
 * 輸入 t -> 不回傳
 * 
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
		
		// forEach 就是實現 Consumer 最經典的例子
		List<String> fruits = List.of("香蕉", "西瓜", "柳丁");
		fruits.forEach(name -> System.out.println(name));
		
		// 切換不同 Consumer 的實現
		Consumer<String> upper = (data) -> System.out.println(data.toUpperCase());
		Consumer<String> lower = (data) -> System.out.println(data.toLowerCase());
		List<String> usernames = List.of("Alice", "Bob", "Candy", "David");
		usernames.forEach(upper);
		usernames.forEach(lower);
	}

}
