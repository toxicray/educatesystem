package com.ray.educatesystem.test;

import com.ray.educatesystem.EducatesystemApplicationTests;
import com.ray.educatesystem.dto.Teacher;
import com.ray.educatesystem.dto.Test1;
import com.ray.educatesystem.mapper.Test1Mapper;
import com.ray.educatesystem.service.TestConcurrencyService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Package:com.ray.educatesystem.transaction
 * *Author:ray
 * *version:...
 * *Created in 2019/7/20  23:41
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
public class TestTransaction {

	@Autowired
	private Test1Mapper mapper;

	@Test
	public void testMapper(){
		List<Test1> list = mapper.selectAll();
		Map<Integer, List<Test1>> collect = list.stream().collect(Collectors.groupingBy(Test1::getId));
		System.out.println(list);
	}

	@Autowired
	private TestConcurrencyService testConcurrencyService;

	@Before
	public void test(){
		System.out.println("开始了!");
	}

	@Test
	public void contextLoads() {
		List<Teacher> teachers = testConcurrencyService.listTeacher();
		System.out.println(teachers.size());
	}


	@Test
	public void multiThread0() {
		List<Teacher> teachers = testConcurrencyService.multiThreadTeacher();
		System.out.println(teachers.size());
	}

	@Test
	public void multiThread1() {
		List<Teacher> teachers = testConcurrencyService.listTeacher();
		System.out.println(teachers.size());
	}

	@Test
	public void singleThread() {
		List<Teacher> teachers = testConcurrencyService.singleThreadTeacher();
		System.out.println(teachers.size());
	}

	@Test
	public void test01(){
		List<Integer> list1= new LinkedList<>();
		List<Integer> list2= new LinkedList<>();
		List<Integer> commen= new LinkedList<>();
		list1.add(1);
		list1.add(2);
		list1.add(3);
		list1.add(4);
		list1.add(5);
		list2.add(5);
		//list1.addAll(commen);
		//commen.add(3);
		//commen.add(4);
		//commen.add(5);
		//list2.addAll(commen);
		list2.add(6);
		list2.add(7);
		//List<Integer> list2= Arrays.asList(3,4,5,6,7);
		boolean b = list1.retainAll(list2);
		print(list1);
		//print(list2);

	}
	public void print(List list){
		for (Object o : list) {
			System.out.println(o);
		}
	}

}
