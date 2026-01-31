package day2;

public class ScoreDemo1 {

	public static void main(String[] args) {
		// Java 考試期末成績計算
		int score1 = 100;
		int score2 = 90;
		int score3 = 80;
		int score4 = 70;
		int score5 = 60;
		
		// 計算總分
		int sum1 = score1 + score2 + score3 + score4 + score5;
		
		// 計算平均
		double avg1 = sum1 / 5.0;
		
		System.out.printf("總分: %d 平均: %.1f%n", sum1, avg1);

	}

}
