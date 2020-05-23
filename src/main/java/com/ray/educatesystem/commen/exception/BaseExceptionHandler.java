package com.ray.educatesystem.commen.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Package:com.ray.educatesystem.commen.exception
 * *Author:ray
 * *version:...
 * *Created in 2019/7/21  0:32
 **/

@ControllerAdvice
public class BaseExceptionHandler {

	@ExceptionHandler(value = Exception.class)
	@ResponseBody
	public String error(Exception e){
		return e.getMessage();
	}
}
