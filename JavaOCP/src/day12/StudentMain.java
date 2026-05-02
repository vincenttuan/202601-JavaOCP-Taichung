package day12;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StudentMain {

	public static void main(String[] args) {
		// 讀取資料: Supplier
		List<Student> students = loader();
		// 篩選條件: Predicate
		Predicate<Student> notNull = (student) -> student != null;
		// 篩選條件: Predicate
		Predicate<Student> pass = (student) -> student.score >= 60;
		// 成績轉換: Function
		Function<Student, String> convert = (student) -> student.name + " => " + getGrade(student.score);
		// 輸出結果: Consumer
		//Consumer<String> print = (str) -> System.out.println(str);
		Consumer<String> print = System.out::println;
		
		// 資料分析 (Pipeline)
		students.stream()
				.filter(notNull.and(pass))    // Predicate: 篩選/過濾
				.map(convert)    // Function: 轉換
				.forEach(print); // Consumer: 輸出
		
	}
	
	// 成績轉換邏輯
	private static String getGrade(int score) {
		switch (score/10) {
			case 10:
			case 9:
				return "A";
			case 8:
				return "B";
			case 7:
				return "C";
			case 6:
				return "D";
			default:
				return "F";
		}
	}
	
	// 讀取資料
	private static List<Student> loader() {
		// 利用 Supplier 讀取檔案資料
		Supplier<List<Student>> loader = () -> {
			
			try {
				//Stream<String> stream = Files.lines(Paths.get("src/day12/student.txt"));
				//stream = stream.filter(line -> line.contains(","));
				
				Stream<String> stream = Files.lines(Paths.get("src/day12/student.txt")).filter(line -> line.contains(","));
				
				List<Student> students = stream.map(line -> {
					String[] arr = line.split(","); // "小明,95" 切割成 ["小明", "95"]
					String name = arr[0].trim();
					Integer score = 0;
					if(arr.length > 1) {
						try {
							score = Integer.valueOf(arr[1].trim()); // 字串轉數字
						} catch (NumberFormatException e) {
							return null;
						}
					}
					// 建立 Student 物件
					Student student = new Student(name, score);
					return student;
				}).collect(Collectors.toList()); // 把所有 student 物件收集起來放到 List 集合中
				
				return students;
				
			} catch (IOException e) {
				System.err.println(e);
			}
			return null;
		};
		
		return loader.get();
	}

}
