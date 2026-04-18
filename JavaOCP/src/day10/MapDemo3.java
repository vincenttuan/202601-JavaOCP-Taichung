package day10;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MapDemo3 {

	public static void main(String[] args) {
		// 所有成績
		List<Integer> scores = List.of(100, 90, 55, 60, 30, 80, 40);
		
		// 分組用 Map
		/*
		 * "及格": [100, 90, 60, 80]
		 * "不及格": [55, 30, 40]
		 * ------------------------
		 *  (key)    (value)
		 * ------------------------ 
		 *  String    List
		 * */
		
		Map<String, List<Integer>> result = new HashMap<>();
		for(int score : scores) {
			
			String key = score >= 60 ? "及格" : "不及格";
			
			// 若集合中沒有此 key 就先建立一個空的 List 集合
			if(!result.containsKey(key)) {
				result.put(key, new ArrayList<>());
			}
			
			// 加入分組
			result.get(key).add(score);
		}
		
		System.out.println(result);
		System.out.println("及格: " + result.get("及格"));
		System.out.println("不及格: " + result.get("不及格"));
		
	}

}
