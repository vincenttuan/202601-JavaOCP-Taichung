package day12;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StudentMain {

	public static void main(String[] args) {
		// 利用 Supplier 讀取檔案資料
		Supplier<List<Student>> loader = () -> {
			
			try {
				Stream<String> stream = Files.lines(Paths.get("src/day12/student.txt"));
				stream = stream.filter(line -> line.contains(","));
				
				List<Student> students = stream.map(line -> {
					String[] arr = line.split(","); // "小明,95" 切割成 ["小明", "95"]
					String name = arr[0];
					Integer score = Integer.valueOf(arr[1]); // 字串轉數字
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
		
		System.out.println(loader.get());

	}

}
