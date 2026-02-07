package day3;

import java.util.Arrays;

public class StringDemo4 {
	public static void main(String[] args) {
		// 字串切割
		String word = "she sell sea shell on the sea shore";
		String[] words = word.split(" "); // 利用"空白"來當成切割字串
		System.out.println(word);
		System.out.println(Arrays.toString(words));
		System.out.printf("第一個字: %s%n", words[0]);
		System.out.printf("第二個字: %s%n", words[1]);
		System.out.printf("最後的字: %s%n", words[words.length-1]);
		
	}
}
