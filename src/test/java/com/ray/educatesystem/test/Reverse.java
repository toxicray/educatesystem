package com.ray.educatesystem.test;

/**
 * Package:com.ray.educatesystem.transaction
 * *Author:ray
 * *version:...
 * *Created in 2019/7/28  12:15
 **/
class Solution {
	 static class TreeNode {
		 int val;
		 TreeNode left;
		 TreeNode right;

		 TreeNode(int x) {
			 val = x;
		 }
	 }

	public TreeNode sortedArrayToBST(int[] nums) {

	 	return toBSTNODe(nums,0,nums.length-1);
	}

	private TreeNode toBSTNODe(int[] nums, int start, int end) {
		if (start>end){
			return null;
		}
		int mid=(start+end)>>>1;
		TreeNode node=new TreeNode(nums[mid]);
		node.left=toBSTNODe(nums, start, mid);
		node.right=toBSTNODe(nums, mid+1, end);
		return node;
	}
}
