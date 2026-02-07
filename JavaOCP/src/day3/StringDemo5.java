package day3;

import java.util.Arrays;
import java.util.Collections;

public class StringDemo5 {

	public static void main(String[] args) {
		String name = "Vincent,Jo,Anita,Howard,Alen,Rose,Bob";
		System.out.printf("原始資料: %s%n%n", name);
		// 1.請問有幾組人名 ?
		System.out.println("=== 題目 1 : 人名統計 ===");
		String[] names = name.split(",");
		int nameCount = names.length;
		System.out.printf("1.有 %d 組人名%n", nameCount);
		System.out.printf("  人名清單: %s%n%n", Arrays.toString(names));
		
		// 2.平均每個人名是幾個字 ?
		System.out.println("=== 題目 2 : 平均字數 ===");
		int totalChars = 0;
		for(int i=0;i<nameCount;i++) {
			int chars = names[i].trim().length(); // 除去空白後取長度
			System.out.printf("%-7s → %d個字%n", names[i].trim(), chars);
			totalChars += chars;
		}
		double avg = (double)totalChars / nameCount;
		System.out.printf("2.總字數: %d 平均: %.1f個字%n%n", totalChars, avg);
		
		// 3.最長與最短的名字是 ?
		System.out.println("=== 題目 3 : 最長最短人名 ===");
		String longest = names[0].trim();
		String shortest = names[0].trim();
		
		for(int i=1;i<names.length;i++) {
			if(names[i].trim().length() > longest.length()) {
				longest = names[i].trim();
				continue;
			} 
			if (names[i].trim().length() < shortest.length()) {
				shortest = names[i].trim();
			}
		}
		System.out.printf("最長: %-7s(%d個字)%n", longest, longest.length());
		System.out.printf("最短: %-7s(%d個字)%n", shortest, shortest.length());
		
		// 4.名字由短 -> 長排序並印出
		System.out.println("=== 題目 4 : 按照人名程度排序(短 → 長) ===");
		
		for(int r=0;r<nameCount-1;r++) {
			for(int i=0;i<nameCount-1-r;i++) {
				String name1 = names[i].trim();
				String name2 = names[i+1].trim();
				// 短在前
				if(name1.length() > name2.length()) {
					// 資料兌換
					String tmp = name1;
					names[i] = names[i+1];
					names[i+1] = tmp;
				}
			}
		}
		System.out.printf("排序後人名清單: %s%n%n", Arrays.toString(names));
		
		
		
	}

}
