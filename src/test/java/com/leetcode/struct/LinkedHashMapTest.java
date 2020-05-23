package com.leetcode.struct;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Package:com.leetcode.struct
 * *Author:ray
 * *version:...
 * *Created in 2020/3/26  22:31
 **/
public class LinkedHashMapTest {
	public static void main(String[] args) {

		LinkedHashMap<String,Integer> map = new LinkedHashMap<String,Integer>(){
			@Override
			protected boolean removeEldestEntry(Map.Entry eldest) {
				return this.size() > 2;
			}
		};
		map.put("1", 1);
		map.put("2", 2);
		map.put("3", 3);
		map.put("4", 4);
		map.forEach((k,v)->{
			System.out.println(k+"----"+v);
		});
	}
}
