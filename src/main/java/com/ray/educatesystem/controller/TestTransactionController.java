package com.ray.educatesystem.controller;

import com.ray.educatesystem.dto.Test1;
import com.ray.educatesystem.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * Package:com.ray.educatesystem.controller
 * *Author:ray
 * *version:...
 * *Created in 2019/7/20  19:54
 **/


@RestController
@CrossOrigin
public class TestTransactionController {


	@Autowired
	private TransactionService service;

	@GetMapping("tran")
	public String testTransaction(){
		service.addTest1();
		return "调用成功";
	}

	@GetMapping("tranT")
	public String testTransactionAnother(){
		service.addTestAnother();
		return "调用成功";
	}


	@GetMapping("asc")
	public String testAsc(){
		Test1 test1=new Test1();
		test1.setName("注解");
		test1.setCount(123);
		service.addTestAsc(test1);
		return "调用成功";
	}


	@GetMapping("getT/{id}")
	public Test1 getTest1ById(@PathVariable("id") Integer id){
		Test1 test=service.getTest1ById(id);
		return test;
	}
}
