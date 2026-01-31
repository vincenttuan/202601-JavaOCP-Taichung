package day2;

public class BMIDemo1 {

	public static void main(String[] args) {
		// 計算某人的 bmi 資料
		// 需要該員的身高與體重
		// bmi 公式 = 體重kg / (身高m)^2
		String name = "小明"; // 人名
		double weight = 60.0; // 體重
		double height = 170.0; // 身高
		double bmi = (weight) / Math.pow(height/100.0, 2);
		
		System.out.println("BMI 執行資料結果:");
		System.out.printf("姓名: %s %n", name);
		System.out.printf("身高: %.1f kg %n", height);
		System.out.printf("體重: %.1f cm %n", weight);
		System.out.printf("bmi: %.2f %n", bmi);
		
		
	}

}
