package day2;

public class BMIDemo2 {

	public static void main(String[] args) {
		// 計算某人的 bmi 資料
		// 需要該員的身高與體重
		// bmi 公式 = 體重kg / (身高m)^2
		// 原始資料
		String name = "小明"; // 人名
		double weight = 60.0; // 體重
		double height = 170.0; // 身高
		
		// 計算 bmi
		double bmi = calcBMI(weight, height);
		
		// 印出結果
		printBMI(name, height, weight, bmi);
		
		// -----------------------------------
		// 原始資料
		String name2 = "小英";
		double weight2 = 45.5;
		double height2 = 160.0;
		
		// 計算 bmi
		double bmi2 = calcBMI(weight2, height2);
		
		// 印出結果
		printBMI(name2, height2, weight2, bmi2);
	}
	
	// 計算 bmi
	private static double calcBMI(double w, double h) {
		double bmi = w / Math.pow(h/100, 2);
		return bmi; // 回傳計算結果
	}
	
	// 印出結果
	private static void printBMI(String name, double h, double w, double bmi) {
		System.out.println("BMI 執行資料結果:");
		System.out.printf("姓名: %s %n", name);
		System.out.printf("身高: %.1f cm %n", h);
		System.out.printf("體重: %.1f kg %n", w);
		System.out.printf("bmi: %.2f %n", bmi);
	}

}
