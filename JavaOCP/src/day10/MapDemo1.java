package day10;

import java.util.HashMap;
import java.util.Map;

public class MapDemo1 {

	public static void main(String[] args) {
		Map<String, String> dict = new HashMap<>();
		dict.put("書", "book");
		dict.put("蘋果", "apple");
		dict.put("電腦", "computer");
		dict.put("手機", "phone");
		
		// 查詢
		System.out.println("書 = " + dict.get("書"));
		System.out.println("手機 = " + dict.get("手機"));
		System.out.println("蘋果 = " + dict.get("蘋果"));
		
		// 查詢不到回傳 null
		System.out.println("香蕉 = " + dict.get("香蕉"));
		
		// 修改(key 重複會覆蓋內容)
		dict.put("蘋果", "apple fruit");
		System.out.println("蘋果更新後 = " + dict.get("蘋果"));
		
		// 判斷是否存在 key
		System.out.println("有沒有電腦? " + dict.containsKey("電腦"));
		
		// 判斷是否存在 value
		System.out.println("phone? " + dict.containsValue("phone"));
		
		// 取得所有的 key
		System.out.println("所有的 key = " + dict.keySet());
		
		// 取得所有的 value
		System.out.println("所有的 value = " + dict.values());
				
		
	}

}
