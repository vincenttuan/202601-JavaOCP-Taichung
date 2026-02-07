package day3;

import java.util.Arrays;

// LeetCode 題目:二數之和(Two Sum)
public class TwoSum {
	
	public static void main(String[] args) {
		int[] nums = {2, 7, 11, 15};
		int target = 13;
		int[] result = new int[2]; // 預設值 = {0, 0}
		int lens = nums.length; // 4
		// 印出初始資料
		System.out.println("印出初始資料");
		System.out.printf("nums = %s%n", Arrays.toString(nums));
		System.out.printf("result = %s%n", Arrays.toString(result));
		
		// 暴力比對
		outer: // 迴圈名字
		for(int i=0 ; i<(lens-1) ; i++) {
			inner: // 迴圈名字
			for(int k=i+1 ; k<lens ; k++) {
				int sum = nums[i] + nums[k];
				System.out.printf("nums[%d][%d] = %d%n", i, k, sum);
				// 判斷
				if(sum == target) {
					result[0] = i;
					result[1] = k;
					break outer;
				}
			}
			
		}
		System.out.println("\n印出結果資料");
		System.out.printf("target = %d%n", target);
		System.out.printf("result = %s%n", Arrays.toString(result));

	}

}
