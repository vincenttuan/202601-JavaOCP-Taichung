package day10;

import java.util.ArrayList;
import java.util.List;

public class ListDemo1 {
	public static void main(String[] args) {
		// ArrayList: 連續記憶體
		// ArrayList: 查詢快, 插入刪除慢
		// [100][80][70][80][90]
		//   0   1   2   3   4
		List<Integer> scores = new ArrayList<>();
		scores.add(80);
		scores.add(70);
		scores.add(80);
		scores.add(90);
		scores.add(0, 100); // 指定插入
		
		System.out.println(scores);
		System.out.println(scores.size());
		System.out.println(scores.get(0)); // 100
		
		// [100][80][70][80][90]
		//   0   1   2   3   4
		//scores.remove(0); // 移除 index = 0 的元素 (將資料搬走)
		//scores.remove(100); // 移除 index=100 的元素 (將資料搬走)
		scores.remove(Integer.valueOf(100)); // 移除 Integer=100 的元素 (將資料搬走)
		// [80][70][80][90]
		//  0   1   2   3
		System.out.println(scores);
		
		
	}
}
