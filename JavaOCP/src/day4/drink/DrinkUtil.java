package day4.drink;

// 處理飲料相關工作
public class DrinkUtil {
	
	/*
	 * 解析訂單字串
	 * "1, 3x2" -> [1號x1杯, 3號x2杯] -> OrderItem[]
	 * */ 
	public static OrderItem[] parseOrder(String input) {
		String[] inputArray = input.split(","); // ["1", "3x2"]
		OrderItem[] oItems = new OrderItem[inputArray.length]; // inputArray.length = 2
		int i = 0; // oItems 起始要放的位置
		for(String item : inputArray) {
			item = item.trim();
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
			
			// 找飲料並建立訂單項目
			Drink drink = DrinkMenu.findByNumber(number);
			// 若沒有該號碼的飲料則當次迴圈不下執行
			if(drink == null) {
				continue;
			}
			// 建立訂單
			OrderItem oItem = new OrderItem(drink, quantity);
			oItems[i] = oItem; // 將 orderItem 放到 oItems 陣列中
			i++; // 很重要
		}
		return oItems;
	}
	
	// 列印單筆商品訂單
	public static void printOrderItem(OrderItem oItem) {
		// 列印訂單資料
		System.out.printf("品名:%s 單價:%d 數量:%d 小計:%d%n", 
				  oItem.getDrink().getName(),
				  oItem.getDrink().getPrice(),
				  oItem.getQuantity(),
				  oItem.getTotalPrice());
	}
	
	// 列印多筆商品訂單
	public static void printOrderItems(OrderItem[] oItems) {
		// 列印訂單資料
		for(OrderItem oItem : oItems) {
			printOrderItem(oItem);
		}
	}
	
}
