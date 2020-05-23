package com.leetcode;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Package:com.leetcode
 * *Author:ray
 * *version:...
 * *Created in 2020/3/19  13:12
 **/
public class IntStreamTest {

	public static void main(String[] args) {
		String str = "cbbd";
		String s = addSignalString(str);
		System.out.println(s);
	}
	public int[] smallerNumbersThanCurrent(int[] nums) {
		int[] result = new int[nums.length];
		for(int i=0;i < nums.length;i++){
			int number = nums[i];
		}
		return result;
	}
	private static boolean isPrime(Integer root){
		int sqrt = (int)Math.sqrt((double) root);
		PriorityQueue<Integer> queue = new PriorityQueue<>(10,(a,b)->a-b);
		Object[] objects = queue.toArray();
		String str = "124";
		char[] chars = str.toCharArray();
		new String(chars,0,0);
		char temp = 0;
		return !IntStream.rangeClosed(2,sqrt).anyMatch(i->root%i==0);
	}



	public String longestPalindrome(String s) {
		String newStr = addSignalString(s);
		char[] chars = newStr.toCharArray();

		String result = "";

		for (int i = 0; i < chars.length; i++) {
			int temp = 0;
			while(i-temp >=0 && i+temp < chars.length){
				if(chars[i-temp] == chars[i+temp]){
					temp++;
				}else{
					break;
				}
			}
			if(temp+1 >result.length()){
				result = s.substring(i-temp,i+temp+1).replaceAll("","#");
			}
		}
		return result;
	}


	private Queue<Integer> queue = new LinkedList<>();



	public int ping(int t) {
		queue.offer(t);
		while(queue.peek() < t-3000){
			queue.poll();
		}
		return queue.size();
	}

	private static String addSignalString(String str){
		StringBuilder sb = new StringBuilder();
		char[] chars = str.toCharArray();
		for (int i = 0; i < chars.length; i++) {
			sb.append("#");
			sb.append(chars[i]);
		}
		double pow = Math.pow(10, 2);
		sb.append("#");
		return sb.toString();
	}
}
