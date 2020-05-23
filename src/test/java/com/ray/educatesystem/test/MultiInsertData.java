package com.ray.educatesystem.test;

import com.google.common.collect.Lists;
import com.ray.educatesystem.dto.Teacher;
import com.ray.educatesystem.mapper.StudentInfoMapper;
import com.ray.educatesystem.mapper.TeacherMapper;
import com.ray.educatesystem.service.InsertService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * Package:com.ray.educatesystem.transaction
 * *Author:ray
 * *version:...
 * *Created in 2019/12/11  21:53
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
public class MultiInsertData {


	@Autowired
	private StudentInfoMapper studentInfoMapper;

	@Autowired
	private TeacherMapper teacherMapper;

	@Autowired
	private InsertService insertService;

	@Test
	public void testGetAll(){
		List<Teacher> list = teacherMapper.select(null);
		int size = list.size();
		long l = System.currentTimeMillis();
		int i = teacherMapper.insertList(list);
		long e = System.currentTimeMillis();
		System.out.println(e-l);
	}

	@Test
	public void testMultiInsert() throws ExecutionException, InterruptedException {
		List<Teacher> list = teacherMapper.select(null);
		List<List<Teacher>> partition = Lists.partition(list, 7300);
		ExecutorService pool = Executors.newFixedThreadPool(5);
		long l = System.currentTimeMillis();
		List<Future> result=new ArrayList<>();
		for (List<Teacher> teachers : partition) {
			Future submit = pool.submit(new Demo(teachers, teacherMapper));
			result.add(submit);
		}
		int num=0;
		for (Future future : result) {
			num+=(Integer) future.get();
		}
		//int i = teacherMapper.insertList(list);
		long e = System.currentTimeMillis();
		System.out.println(e-l);
		System.out.println(num);
	}

	@Test
	public void testMultiTest() throws InterruptedException, ExecutionException {
		List<Teacher> list = teacherMapper.select(null);
		List<List<Teacher>> partition = Lists.partition(list, 7300);
		ExecutorService pool = Executors.newFixedThreadPool(4);
		CompletionService service=new ExecutorCompletionService(pool);
		List<Future<Integer>> futures = new ArrayList<>();
		for (List<Teacher> teachers : partition) {
			futures.add(service.submit(new Demo(teachers,teacherMapper)));
		}
		try {
			for (int i = 0; i < 3; i++) {
				Object o = service.take().get();
				if (null != o){
					break;
				}
			}
		} finally  {
			for (Future<Integer> future : futures) {
				future.cancel(true);
			}

		}

	}
	@Test
	public void testMultiTest1() throws InterruptedException, ExecutionException {
		List<Teacher> list = teacherMapper.select(null);
		List<List<Teacher>> partition = Lists.partition(list, 7300);
		ExecutorService pool = Executors.newFixedThreadPool(4);
		CompletionService service=new ExecutorCompletionService(pool);
		List<Future<Integer>> futures = new ArrayList<>();
		for (List<Teacher> teachers : partition) {
			futures.add(service.submit(new Demo1(teachers,insertService)));
		}
		try {
			for (int i = 0; i < 3; i++) {
				Object o = service.take().get();
				if (null != o){
					break;
				}
			}
		} finally  {
			for (Future<Integer> future : futures) {
				future.cancel(true);
			}

		}

	}








	class Demo implements Callable{

		private List<Teacher> list;

		private TeacherMapper teacherMapper;

		public Demo(List<Teacher> list, TeacherMapper teacherMapper) {
			this.list = list;
			this.teacherMapper = teacherMapper;
		}

		@Override
		public Object call() throws Exception {
			int i = teacherMapper.insertList(list);
			return i;
		}
	}


	class Demo1 implements Callable{

		private List<Teacher> list;

		private InsertService teacherMapper;

		public Demo1(List<Teacher> list, InsertService teacherMapper) {
			this.list = list;
			this.teacherMapper = teacherMapper;
		}

		@Override
		public Object call() throws Exception {
			int i = teacherMapper.insertList(list);
			return i;
		}
	}

	//9171条数据   单线程插入   耗时1115秒
	//18342条数据   单线程插入   耗时1725秒
	//36684条数据   单线程插入   耗时2669秒
	//36682条数据   2000条数据     5个线程    2010
	//36682条数据   7200条数据     5个线程    1950


}
