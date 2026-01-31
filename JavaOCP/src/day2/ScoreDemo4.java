package day2;

public class ScoreDemo4 {

	public static void main(String[] args) {
		// 利用陣列來儲存 5 個學生物件
		Student[] students = {
				new Student("John", 95),
				new Student("Mary", 50),
				new Student("Alen", 83),
				new Student("Jack", 40),
				new Student("Rose", 60)
		};
		
		// 印出學生成績
		Student.printAll(students);
		
		// 印出總分
		System.out.printf("總分: %d%n", Student.getSum(students)); 
		
		// 印出平均
		System.out.printf("平均: %.1f%n", Student.getAvg(students)); 
	}

}
