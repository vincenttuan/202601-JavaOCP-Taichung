package day9;

import java.util.HashSet;
import java.util.Set;

import day9.entity.Student;

public class SetDemo6 {
	public static void main(String[] args) {
		// 集合單一元素: String, Integer ...
		// 集合複合元素: 自訂物件
		Set<Student> students = new HashSet<>();
		students.add(new Student("Alice", 85, 2, 20));
		students.add(new Student("Bob", 92, 1, 22));
		students.add(new Student("Cindy", 78, 2, 19));
		students.add(new Student("David", 88, 1, 21));
		students.add(new Student("Eva", 95, 2, 23));
		students.add(new Student("Frank", 67, 1, 20));
		students.add(new Student("Grace", 73, 2, 22));
		students.add(new Student("Henry", 81, 1, 24));
		students.add(new Student("Ivy", 90, 2, 21));
		students.add(new Student("Jack", 76, 1, 19));
		students.add(new Student("Jack", 76, 1, 19));
		students.add(new Student("Jack", 76, 1, 19));
		students.add(new Student("Jack", 76, 1, 19));
		students.add(new Student("Jack", 76, 1, 19));
		students.add(new Student("Jack", 76, 1, 19));
		
		System.out.println("個數:" + students.size());
		
		// 印出學生資料(傳統寫法)
		for(Student student : students) {
			System.out.println(student);
		}
		
		// 印出學生資料(新寫法)
		students.forEach(student -> {
			System.out.println(student);
		});
		
		// 印出學生資料(新寫法 + :: = 極簡寫法)
		students.forEach(System.out::println);
		
		// 印出分數
		students.forEach(student -> {
			System.out.println(student.getScore());
		});
		
		// 請計算總分 = ?
		int sum = students.stream() // student 物件串流
						  .mapToInt(student -> student.getScore()) // score 串流
						  .sum();
		System.out.println("總分:" + sum);
		
	}
}
