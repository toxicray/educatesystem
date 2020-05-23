package com.leetcode;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Package:com.leetcode
 * *Author:ray
 * *version:...
 * *Created in 2020/3/19  12:23
 **/
public class Q409 {
	public static void main(String[] args) {
		int result = longestpalindrome("hellloe");
		int result1 = longestpalindrome1("hellloe");
		String str = reverseStr("hello world");
		System.out.println(str);
		char a = (char) 57;

		int a1 = 'z';
		int a2 = 'A';

		System.out.println(a1+"-----"+a2);

		//IntStream.rangeClosed(65,122).map(i->(char)i).forEach(item->{
		//	System.out.println((char) item);
		//});

	}

	private static String reverseStr(String s) {
		List<char[]> chars = Arrays.asList(s.toCharArray());
		Collections.reverse(chars);
		return new String(chars.get(0));
	}

	private static int longestpalindrome1(String s) {
		int[] arr=new int[58];
		for (char c : s.toCharArray()) {
			arr[c-'A'] +=1;
		}
		int result = 0;
		for (int i : arr) {
			result += i-(i&1);
		}
		return result<s.length()?result+1:result;
	}

	private static int longestpalindrome(String param) {
		Map<Integer, Integer> map = param.chars()
				.boxed()
				.collect(Collectors.toMap(k -> k, v -> 1, Integer::sum));
		int sum = map.values().stream().mapToInt(i -> i - (i & 1)).sum();
		return sum<param.length()?sum+1:sum;
	}


}
