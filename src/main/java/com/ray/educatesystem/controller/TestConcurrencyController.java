package com.ray.educatesystem.controller;

import com.ray.educatesystem.bo.StudentBO;
import com.ray.educatesystem.service.TestConcurrencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ExecutionException;

/**
 * Package:com.ray.educatesystem.controller
 * *Author:ray
 * *version:...
 * *Created in 2019/11/24  11:52
 **/
@RestController
public class TestConcurrencyController {

	@Autowired
	private TestConcurrencyService testConcurrency;

	@GetMapping("curr")
	public StudentBO getInfo() throws ExecutionException, InterruptedException {
		return testConcurrency.getInfoByConcurrency();

	}




}
