package day4;

public class TestSplit {

	public static void main(String[] args) {
		System.out.println("測試資料");
		System.out.println("=================");
		
		// "1, 3x2" 
		// 1號x1杯
		// 3號x2杯
		
		String input = "1, 3x2, 5x3";
		String[] inputArray = input.split(","); // ["1", "3x2"]
		
		for(String item : inputArray) {
			item = item.trim();
			System.out.printf("item:%s%n", item);
			
			int number = 0; // 飲料號碼
			int quantity = 0; // 數量
			// 判斷是否有 "x"
			if(item.contains("x")) {
				String[] array = item.split("x"); // ["3", "2"]
				number   = Integer.parseInt(array[0]); // 字串轉 int
				quantity = Integer.parseInt(array[1]); // 字串轉 int
			} else {
				number = Integer.parseInt(item); // item 就是飲料號碼
				quantity = 1; // 預設 = 1
			}
			// 印出結果
			System.out.printf("%d號x%d杯%n", number, quantity);
			
			// 找飲料並建立訂單項目
			Drink drink = DrinkMenu.findByNumber(number);
			OrderItem oItem = new OrderItem(drink, quantity);
			// 列印訂單資料
			System.out.printf("品名:%s 單價:%d 數量:%d 小計:%d%n", 
					  oItem.getDrink().getName(),
					  oItem.getDrink().getPrice(),
					  oItem.getQuantity(),
					  oItem.getTotalPrice());
			System.out.println(); 
		}

	}

}
