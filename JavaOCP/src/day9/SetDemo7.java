package day9;

import java.util.HashSet;
import java.util.IntSummaryStatistics;
import java.util.Set;

import day9.entity.Student;

public class SetDemo7 {

	public static void main(String[] args) {
		Set<Student> students = Set.of(
			new Student("Alice", 85, 2, 20),
			new Student("Bob", 92, 1, 22),
			new Student("Cindy", 78, 2, 19),
			new Student("David", 88, 1, 21),
			new Student("Eva", 95, 2, 23),
			new Student("Frank", 67, 1, 20),
			new Student("Grace", 73, 2, 22),
			new Student("Henry", 81, 1, 24),
			new Student("Ivy", 90, 2, 21),
			new Student("Jack", 76, 1, 19)
		);
		
		students.forEach(System.out::println);
		
		// 統計資料
		IntSummaryStatistics stat = students.stream()
											.mapToInt(Student::getScore)
											.summaryStatistics();
		
		System.out.println("統計物件:" + stat);
		System.out.println("個數:" + stat.getCount());
		System.out.println("總和:" + stat.getSum());
		System.out.println("平均:" + stat.getAverage());
		System.out.println("最大:" + stat.getMax());
		System.out.println("最小:" + stat.getMin());
		
	}

}
