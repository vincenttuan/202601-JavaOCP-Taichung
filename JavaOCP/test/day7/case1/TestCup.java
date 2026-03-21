package day7.case1;

public class TestCup {
	public static void main(String[] args) {
		Cup paperCup = new PaperCup("紙杯");
		Cup mug = new Mug("馬克杯");
		
		System.out.println("=== 製作杯子 ===");
		paperCup.make();
		mug.make();
		
		System.out.println("\n=== 裝水測試 ===");
		paperCup.fill();
		mug.fill();
		
	}
}
