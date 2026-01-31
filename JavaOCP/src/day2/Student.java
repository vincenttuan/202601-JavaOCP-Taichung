package day2;

public class Student {
	String name; // 姓名
	int score; // 成績
	
	// 建構子
	public Student(String name, int score) {
		this.name = name;
		this.score = score;
	}
	
	// 方法:印出自己的成績
	public void printScore() {
		System.out.printf("學員: %s 成績: %d%n", name, score);
	}
	
}
