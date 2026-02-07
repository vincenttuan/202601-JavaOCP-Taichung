package day3;

import java.util.Arrays;

// 泡沫排序法
public class BubbleSort {

	public static void main(String[] args) {
		int[] nums = {5, 3, 8, 4, 2};
		int lens = nums.length; // 5
		System.out.printf("原始陣列: %s%n", Arrays.toString(nums));
		
		// 要跑的回合數
		for(int r=0;r<nums.length;r++) {
			// 倆倆比對的迴圈
			for(int i=0 ; i<lens-1 ; i++) {
				
				if(nums[i] > nums[i+1]) {
					int tmp = nums[i];
					nums[i] = nums[i+1];
					nums[i+1] = tmp;
				}
				
				System.out.printf("過程陣列: %s%n", Arrays.toString(nums));
			}
			System.out.println("----------------------");
		}
		
	}

}
