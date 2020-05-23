package com.ray.educatesystem.service;

import com.github.pagehelper.PageHelper;
import com.ray.educatesystem.bo.StudentBO;
import com.ray.educatesystem.dto.StudentInfo;
import com.ray.educatesystem.dto.Teacher;
import com.ray.educatesystem.mapper.StudentInfoMapper;
import com.ray.educatesystem.mapper.TeacherMapper;
import com.ray.educatesystem.util.RunnableDemo;
import com.sun.xml.internal.ws.util.CompletedFuture;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * Package:com.ray.educatesystem.service
 * *Author:ray
 * *version:...
 * *Created in 2019/11/24  11:53
 **/

@Service
public class TestConcurrencyService {

	@Autowired
	private StudentInfoMapper studentInfoMapper;

	@Autowired
	private TeacherMapper teacherMapper;

	private ExecutorService executorService= Executors.newCachedThreadPool();

	public StudentBO getInfoByConcurrency() throws ExecutionException, InterruptedException {
		long l = System.currentTimeMillis();
		StudentBO bo=new StudentBO();
		bo.setId(1);
		//CompletableFuture<StudentInfo> future= CompletableFuture.supplyAsync(()->{
		//	try {
		//		Thread.sleep(2000);
		//	} catch (InterruptedException e) {
		//		e.printStackTrace();
		//	}
		//	return studentInfoMapper.selectByPrimaryKey(bo.getId());
		//});
		//CompletableFuture<Teacher> future1= CompletableFuture.supplyAsync(()->{
		//	try {
		//		Thread.sleep(2000);
		//	} catch (InterruptedException e) {
		//		e.printStackTrace();
		//	}
		//	return teacherMapper.selectByPrimaryKey(bo.getId());
		//});
		//StudentInfo studentInfo = future.get();
		//BeanUtils.copyProperties(studentInfo,bo );
		//Teacher teacher = future1.get();
		//BeanUtils.copyProperties(teacher,bo);
		Future<StudentBO> submit = executorService.submit(new RunnableDemo(bo,studentInfoMapper,teacherMapper), bo);
		StudentBO studentBO = submit.get();
		return submit.get();
		//Long time=System.currentTimeMillis()- l;
		//System.out.println(time);
		//return bo;
	}

	public List<Teacher> listTeacher(){
		PageHelper.startPage(1, 10);
		List<Teacher> select = teacherMapper.select(null);
		return select;
	}


	public List<Teacher> singleThreadTeacher(){
		long l = System.currentTimeMillis();
		//PageHelper.startPage(1, 10);
		List<Teacher> select = teacherMapper.select(null);
		Long time=System.currentTimeMillis()- l;
		System.out.println(time);
		return select;
	}


	public List<Teacher> singleThreadTeacher1(){
		long l = System.currentTimeMillis();
		//PageHelper.startPage(1, 10);
		//List<Teacher> select = teacherMapper.select(null);
		int i = teacherMapper.selectCount(null);
		List<Teacher> result=new ArrayList<>(10000);
		int page=i%100==0?i/100:i/100+1;
		int start=1;
		while (start<page){
			PageHelper.startPage(start, 1000);
			List<Teacher> list = teacherMapper.select(null);
			start++;
			result.addAll(list);
		}
		Long time=System.currentTimeMillis()- l;
		System.out.println(time);
		return result;
	}






	public List<Teacher> multiThreadTeacher(){
		long l = System.currentTimeMillis();
		//PageHelper.startPage(1, 10);
		//List<Teacher> select = teacherMapper.select(null);
		int i = teacherMapper.selectCount(null);
		List<Teacher> result=new ArrayList<>(10000);
		int page=i%1000==0?i/1000:i/1000+1;
		int start=1;
		while (start<=page){
			PageHelper.startPage(start, 1000);
			List<Teacher> list = teacherMapper.select(null);
			start++;
			result.addAll(list);
		}
		Long time=System.currentTimeMillis()- l;
		System.out.println(time);
		return result;
	}








}
