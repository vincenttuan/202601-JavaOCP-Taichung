package day2;

public class ScoreDemo2 {

	public static void main(String[] args) {
		// 利用陣列把重複程式改善
		String[] names = {"John", "Mary", "Alen", "Jack", "Rose"};
		int[] scores   = {95    , 50    , 83    , 40    , 60};
		
		// 利用 for 迴圈印出所有學員成績
		for(int i=0;i<names.length;i++) {
			System.out.printf("學員: %s 成績: %d%n", names[i], scores[i]);
		}
		System.out.println("------------------");
		
		// 用 for 迴圈計算總分
		int sum = 0; // 總分初始值
		for(int i=0;i<scores.length;i++) {
			sum = sum + scores[i];
		}
		
		double avg = sum / (double)names.length; // 總分 / 人數
		
		System.out.printf("總分: %d%n", sum);
		System.out.printf("平均: %.1f%n", avg);
	}

}
