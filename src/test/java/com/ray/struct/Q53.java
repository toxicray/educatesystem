package com.ray.struct;

/**
 * Package:com.ray.struct
 * *Author:ray
 * *version:...
 * *Created in 2019/12/17  21:49
 **/
public class Q53 {
	public static void main(String[] args) {
		int[] nums = new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4};
		int result = getMax(nums);
		System.out.println(result);
	}

	private static int getMax(int[] nums) {
		int curSum = nums[0];
		int maxSum = nums[0];
		for (int i = 1; i < nums.length; i++) {
			curSum=Math.max(nums[i],curSum+nums[i] );
			maxSum=Math.max(curSum, maxSum);
		}
		return maxSum;
	}
}
