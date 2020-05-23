package com.ray.educatesystem.java8;

import org.junit.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/**
 * Package:com.ray.educatesystem.java8
 * *Author:ray
 * *version:...
 * *Created in 2019/11/5  22:47
 **/
public class StreamPractice {
	public static void main(String[] args) {




	}
	@Test
	public void testFlatMap(){
		List<String> list = new ArrayList<>();
		list.add("aaa bbb ccc");
		list.add("ddd eee fff");
		list.add("ggg hhh iii");

		list = list.stream().map(s -> s.split(" ")).flatMap(Arrays::stream).collect(Collectors.toList());
		list.stream().forEach(s->{
			System.out.println(s);
		});
	}
	@Test
	public void testInteger(){
		List<String> list = new ArrayList<>();
		list.add("aaa bbb ccc");
		list.add("ddd eee fff");
		list.add("ggg hhh iii");
		String collect = list.stream().collect(Collectors.joining());
		System.out.println(collect);
	}

	@Test
	public void testfileToStream() throws IOException {
		String str="S:\\ray_project\\educatesystem\\src\\test\\java\\com\\ray\\educatesystem\\java8\\abc.txt";
		long count = Files.lines(Paths.get(str)).count();
		System.out.println(count);
		Map<Integer, List<Integer>> collect = Files.lines(Paths.get(str)).map(s -> Integer.parseInt(s)).collect(Collectors.groupingBy(str1 -> str1));
	}
}
