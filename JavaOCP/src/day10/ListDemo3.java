package day10;

import java.util.ArrayList;
import java.util.List;

public class ListDemo3 {
	public static void main(String[] args) {
		List<Integer> allList = new ArrayList<>();
		allList.add(5);
		allList.add(10);
		allList.add(15);
		allList.add(20);
		allList.add(25);
		System.out.println(allList);
		
		allList.forEach(data -> {
			System.out.println(data);
		});
		
		allList.forEach(System.out::println);
		
		// 子集合
		// fromIndex(含), toIndex(不含)
		List<Integer> sub1 = allList.subList(0, 3); // 0, 1, 2, 3(不含)
		System.out.println(sub1);
		
		
	}
}
