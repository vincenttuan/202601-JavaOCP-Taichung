package day10;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class ListDemo8 {

	public static void main(String[] args) {
		// Set + List
		/*
		 * student1 -> [100, 90, 80], [90, 90, 90], [85, 80, 50]
		 * student2 -> [70, 60, 50], [80, 100, 100], [75, 80, 90]
		 * 
		 * */
		// student1 / student2 的多次考試成績
		List<Integer> s1_score1 = List.of(100, 90, 80);
		List<Integer> s1_score2 = List.of(90, 90, 90);
		List<Integer> s1_score3 = List.of(85, 80, 50);
		
		List<Integer> s2_score1 = List.of(70, 60, 50);
		List<Integer> s2_score2 = List.of(80, 100, 100);
		List<Integer> s2_score3 = List.of(75, 80, 90);
		
		// Set + List (學生集合)
		Set<List<Integer>> students = new LinkedHashSet<>();
		// student1
		students.add(s1_score1);
		students.add(s1_score2);
		students.add(s1_score3);
		// student2
		students.add(s2_score1);
		students.add(s2_score2);
		students.add(s2_score3);
		
		// 印出所有資料
		students.forEach(scores -> {
			System.out.println(scores);
		});
	}

}
