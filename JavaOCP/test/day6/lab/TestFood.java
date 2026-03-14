package day6.lab;

public class TestFood {

	public static void main(String[] args) {
		System.out.println("NightMarketFood 測試 =====");
		Food night = new NightMarketFood();
		night.order();
		night.order("蚵仔煎");
		night.order("蛋炒飯", 2);
		night.prepare();
		night.serve();
		
		System.out.println("\nHotPotFood 測試 =====");
		Food hotpot = new HotPotFood();
		hotpot.order();
		hotpot.order("羊肉片");
		hotpot.order("臭豆腐", 3);
		hotpot.prepare();
		hotpot.serve();
		
		System.out.println();
		Food[] foods = {night, hotpot};
		for(Food food : foods) {
			food.order();
			food.prepare();
			food.serve();
		}
		
	}

}
