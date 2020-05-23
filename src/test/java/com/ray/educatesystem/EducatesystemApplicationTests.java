package com.ray.educatesystem;

import com.ray.educatesystem.dto.Teacher;
import com.ray.educatesystem.dto.Test1;
import com.ray.educatesystem.service.TestConcurrencyService;
import com.ray.educatesystem.service.TestUpdateService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.concurrent.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EducatesystemApplicationTests {

	@Autowired
	private TestConcurrencyService testConcurrencyService;

	@Before
	public void test() {
		System.out.println("开始了!");
	}

	@Test
	public void contextLoads() {
		List<Teacher> teachers = testConcurrencyService.listTeacher();
		System.out.println(teachers.size());
	}


	@Test
	public void calculateAsync() throws InterruptedException, ExecutionException {
		CompletableFuture<String> completableFuture = new CompletableFuture<>();

		Executors.newCachedThreadPool().submit(() -> {
			Thread.sleep(500);
			completableFuture.complete("Hello");
			return null;
		});
		System.out.println(completableFuture.get());
	}

	@Test
	public void test01() {
		List<Integer> list1 = Arrays.asList(1, 2, 3, 4, 5);
		List<Integer> list2 = Arrays.asList(3, 4, 5, 6, 7);
		boolean b = list1.retainAll(list2);
		print(list1);
		print(list2);

	}

	public void print(List list) {
		for (Object o : list) {
			System.out.println(o);
		}
	}



}
