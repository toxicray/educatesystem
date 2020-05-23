package com.leetcode;

/**
 * Package:com.leetcode
 * *Author:ray
 * *version:...
 * *Created in 2020/3/22  19:08
 **/
public class TryLeetcode {
	public static void main(String[] args) {


		
	}

	public static int getMethod(int num){
		int result =1;
		while (num > 0){
			result *= num;
			num--;
		}
		return result;
	}
	public int numIslands(char[][] grid) {
		int result = 0;
		int length = grid.length;
		int width = grid[0].length;
		for (int i = 0; i < length; i++) {
			for (int j = 0; j < width; j++) {
				result+=judge(grid,i,j);
			}
		}
		return result;
	}

	private int judge(char[][] grid, int i, int j) {
		if(grid[i][j] == '0'){
			return 0;
		}else{
			int length = grid.length;
			int width = grid[0].length;

			if(i-1 > 0 && j-1 > 0){
				if (grid[i-1][j] == '0' && grid[i][j-1] == '0') {
					return 1;
				}
			}
			if(j-1 > 0){
				if (grid[i][j-1] == '0'){
					return 1;
				}
			}
			if(i-1 > 0){
				if (grid[i-1][j] == '0'){
					return 1;
				}
			}
		}
		return 0;
	}
}
