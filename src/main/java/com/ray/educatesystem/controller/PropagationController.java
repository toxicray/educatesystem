package com.ray.educatesystem.controller;

import com.ray.educatesystem.service.PropagationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Package:com.ray.educatesystem.controller
 * *Author:ray
 * *version:...
 * *Created in 2020/1/10  0:14
 *
 *
 **/
@RestController
public class PropagationController {

	@Autowired
	private PropagationService propagationService;

	@GetMapping("ray")
	public String testPropagate(){
		propagationService.insertList();
		propagationService.insertList1();
		return "调用成功";
	}

}
