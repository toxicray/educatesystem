package com.ray.educatesystem.interceptor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Random;

/**
 * Package:com.ray.educatesystem.interceptor
 * *Author:ray
 * *version:...
 * *Created in 2020/3/26  0:15
 **/
public class LoginInterceptor extends HandlerInterceptorAdapter {

	@Autowired
	private ThreadLocalUtil util;

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		Random random = new Random();
		int num = random.nextInt(10);
		util.local.set(num);
		System.out.println(num);
		return true;
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
		System.out.println(util.local.get()+ "访问结束");
		util.local.remove();
	}
}
