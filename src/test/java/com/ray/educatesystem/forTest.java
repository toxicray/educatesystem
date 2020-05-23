package com.ray.educatesystem;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Package:com.ray.educatesystem
 * *Author:ray
 * *version:...
 * *Created in 2019/12/1  10:49
 **/
public class forTest {
	public static void main(String[] args) {

		List<Integer> list1= new LinkedList<>();
		List<Integer> list2= new LinkedList<>();
		List<Integer> commen= new LinkedList<>();
		list1.add(1);
		list1.add(2);
		list1.add(3);
		list1.add(4);
		list1.add(5);
		list2.add(5);
		list2.add(6);
		list2.add(7);
		//boolean b = list1.retainAll(list2);
		//print(list1);
		list1.stream();
		Set<Integer> collect = Stream.
				concat(list1.stream(), list2.stream()).collect(Collectors.toSet());
		print(collect);
		//list1.stream().collect();
	}
	public static void print(Collection list){
		for (Object o : list) {
			System.out.println(o);
		}
	}

}
