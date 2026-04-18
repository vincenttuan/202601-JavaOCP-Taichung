package day10;

import java.util.LinkedList;
import java.util.List;

public class ListDemo2 {
	public static void main(String[] args) {
		// LinkedList: 不連續記憶體 (用指標串接)
		// LinkedList: 查詢慢, 插入刪除快
		// [80] -> [70] -> [80] -> [90]
		List<Integer> scores = new LinkedList<>();
		scores.add(80);
		scores.add(70);
		scores.add(80);
		scores.add(90);
		
		scores.add(1, 100); // 指定插入
		
		//       v-------------------------+   
		// [80]  [70] -> [80] -> [90]  [100]
		//    +-------------------------^
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
