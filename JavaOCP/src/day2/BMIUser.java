package day2;

// 物件結構
public class BMIUser {
	// 3個資料(物件屬性)
	String name;
	double weight;
	double height;
	
	// 建構子
	public BMIUser() {
		
	}
	
	public BMIUser(String name, double height, double weight) {
		this.name = name;
		this.height = height;
		this.weight = weight;
	}
	
	// 2個邏輯(物件方法)
	private double calcBMI() {
		double bmi = weight / Math.pow(height/100, 2);
		return bmi;
	}
	
	public void printBMI() {
		double bmi = calcBMI(); // 直接調用已經寫好的 bmi 計算邏輯
		System.out.println("BMI 執行資料結果:");
		System.out.printf("姓名: %s %n", name);
		System.out.printf("身高: %.1f cm %n", height);
		System.out.printf("體重: %.1f kg %n", weight);
		System.out.printf("bmi: %.2f %n", bmi);
	}
	
}
