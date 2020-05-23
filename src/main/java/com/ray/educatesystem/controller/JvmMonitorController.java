package com.ray.educatesystem.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Package:com.ray.educatesystem.controller
 * *Author:ray
 * *version:...
 * *Created in 2020/3/1  16:29
 **/
@RestController
public class JvmMonitorController {


	@GetMapping("jvm")
	public Object getJvmStack(){
		return 	Thread.getAllStackTraces();
	}




}
