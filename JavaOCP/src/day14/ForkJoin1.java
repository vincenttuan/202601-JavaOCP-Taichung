package day14;

import java.util.List;

public class ForkJoin1 {

	public static void main(String[] args) {
		// 平方和的計算
		List<Integer> nums = List.of(3, 1, 4, 2, 5, 9);
		int sum = nums.stream()
					  .peek(n -> System.out.printf("%s 拿到原始 %d%n", Thread.currentThread().getName(), n))
					  .mapToInt(n -> n * n) // 資料轉換
					  //.peek(n -> System.out.printf("%s 拿到結果 %d%n", Thread.currentThread().getName(), n))
					  .sum();
		
		System.out.println(sum);
		

	}

}
