package day2;

// 物件結構
public class BMIUser {
	String name;
	double weight;
	double height;
	
	private double calcBMI(double w, double h) {
		double bmi = w / Math.pow(h/100, 2);
		return bmi;
	}
	
	public void printBMI(String name, double h, double w) {
		double bmi = calcBMI(w, h); // 直接調用已經寫好的 bmi 計算邏輯
		System.out.println("BMI 執行資料結果:");
		System.out.printf("姓名: %s %n", name);
		System.out.printf("身高: %.1f cm %n", h);
		System.out.printf("體重: %.1f kg %n", w);
		System.out.printf("bmi: %.2f %n", bmi);
	}
	
}
