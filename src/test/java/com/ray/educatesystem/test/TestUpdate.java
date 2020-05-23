package com.ray.educatesystem.test;

import com.ray.educatesystem.EducatesystemApplicationTests;
import com.ray.educatesystem.dto.Teacher;
import com.ray.educatesystem.dto.Test1;
import com.ray.educatesystem.mapper.Test1Mapper;
import com.ray.educatesystem.service.TestConcurrencyService;
import com.ray.educatesystem.service.TestUpdateService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
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
public class TestUpdate {

	@Autowired
	private Test1Mapper mapper;

	@Test
	public void testMapper(){
		List<Test1> list = mapper.selectAll();
		Map<Integer, List<Test1>> collect = list.stream().collect(Collectors.groupingBy(Test1::getId));
		System.out.println(list);
	}

	@Autowired
	private TestUpdateService testUpdateService;

	@Test
	public void testUpdateMapper(){
		Test1 test1 = new Test1();
		test1.setId(105);
		test1.setName("加上");
		test1.setCreateTime(new Date());
		testUpdateService.testUpdate(test1);
	}
}
