package day10;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ListDemo5 {

	public static void main(String[] args) {
		List<String> user1 = List.of("tea", "tea", "coffee", "milk");
		List<String> user2 = List.of("coffee", "milk", "juice");
		List<String> user3 = List.of("milk", "milk", "coffee", "milk");
		
		// 取出交集
		// 有效率的寫法是使用 Set
		// 因 Set  在使用 contain 查找的效率是 O(1)
		// 而 List 在使用 contain 查找的效率是 O(n)
		Set<String> drink1 = new HashSet<>(user1); // 利用 Set 去重
		Set<String> drink2 = new HashSet<>(user2);
		Set<String> drink3 = new HashSet<>(user3);
		
		Set<String> result = new HashSet<>(drink1);
		result.retainAll(drink2);
		result.retainAll(drink3);
		
		System.out.println(result);

	}

}
