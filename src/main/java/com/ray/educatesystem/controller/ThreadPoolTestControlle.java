package com.ray.educatesystem.controller;

import com.ray.educatesystem.service.ThreadPoolTestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Package:com.ray.educatesystem.controller
 * *Author:ray
 * *version:...
 * *Created in 2020/2/16  18:54
 **/
@RestController
public class ThreadPoolTestControlle {

	@Autowired
	private ThreadPoolTestService service;

	@GetMapping("pool1")
	public void test1Method(){
		service.testAsync();
	}

	@GetMapping("pool2")
	public void testCustomMethod(){
		service.testCustomAsync();
	}

	@GetMapping("pool3")
	public String testAsyncCustomMethod(){
		return service.testAsyncCustomAsync();
	}
}
