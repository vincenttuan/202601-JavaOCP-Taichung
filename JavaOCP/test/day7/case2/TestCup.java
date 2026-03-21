package day7.case2;

public class TestCup {

	public static void main(String[] args) {
		Cup glassCup = new GlassCup("玻璃杯");
		Cup steelCup = new SteelCup("不鏽鋼杯");
		
		System.out.println("=== 製作杯子 ===");
		glassCup.make();
		steelCup.make();
		
		System.out.println("\n=== 裝水測試 ===");
		glassCup.fill();
		steelCup.fill();
	}

}
