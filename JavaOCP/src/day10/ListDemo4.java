package day10;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class ListDemo4 {
	public static void main(String[] args) {
		// 交集 intersection
		// 差集 difference
		
		List<Integer> list1 = new ArrayList<>(); // 1, 2, 3, 4
		list1.add(1);list1.add(2);list1.add(3);list1.add(4);
		System.out.println(list1);
		
		List<Integer> list2 = new ArrayList<>(); // 3, 4, 5, 6
		list2.add(3);list2.add(4);list2.add(5);list2.add(6);
		System.out.println(list2);
		
		// 交集 -> retainAll
		List<Integer> intersection = new ArrayList<>(list1);
		intersection.retainAll(list2);
		System.out.println(intersection);
		
		// 差集 (list1 - list2) -> removeAll
		List<Integer> difference = new ArrayList<>(list1);
		difference.removeAll(list2);
		System.out.println(difference);
		
		// 聯集 (可重複) -> addAll
		List<Integer> union = new ArrayList<>(list1);
		union.addAll(list2);
		System.out.println(union);
		
		// 聯集 (不可重複) -> addAll
		Set<Integer> unionSet = new LinkedHashSet<>(list1);
		unionSet.addAll(list2);
		System.out.println(unionSet);
		
		// 對稱差集 (只出現在一邊)
		List<Integer> symmetricDifference = new ArrayList<>(union); // 聯集
		symmetricDifference.removeAll(intersection); // 聯集 - 交集
		System.out.println(symmetricDifference);
		
	}
}







