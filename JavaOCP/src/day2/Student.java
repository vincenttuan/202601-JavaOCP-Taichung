package day2;

public class Student {
	private String name; // 姓名(只有自己能用)
	private int score; // 成績(只有自己能用)
	
	// 建構子
	public Student(String name, int score) {
		this.name = name;
		this.score = score;
	}
	
	// 方法:印出自己的成績
	public void printScore() {
		System.out.printf("學員: %s 成績: %d%n", name, score);
	}
	
	// 方法:回傳自己的成績(給別人使用)
	public int getScore() {
		return score;
	}
}
