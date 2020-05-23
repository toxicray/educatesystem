package com.ray.educatesystem.controller;

import com.ray.educatesystem.interceptor.ThreadLocalUtil;
import com.ray.educatesystem.service.TestTransactionPropagaService;
import com.ray.educatesystem.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;

/**
 * Package:com.ray.educatesystem.controller
 * *Author:ray
 * *version:...
 * *Created in 2019/11/9  17:36
 **/
@RequestMapping
@RestController
public class RayTestController {

	@Autowired
	private TestTransactionPropagaService testTransactionPropagaService;

	@Autowired
	private ThreadLocalUtil util;


	@GetMapping("rayTest")
	public String testPropagate(){
		//testTransactionPropagaService.testOuterTransaction();
		RequestAttributes requestAttributes = RequestContextHolder.currentRequestAttributes();
		return util.local.get().toString();
	}

}
