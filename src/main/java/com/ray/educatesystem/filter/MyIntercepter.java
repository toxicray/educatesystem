package com.ray.educatesystem.filter;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Package:com.ray.educatesystem.filter
 * *Author:ray
 * *version:...
 * *Created in 2020/2/17  9:16
 **/
public class MyIntercepter extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		System.out.println(request.getContextPath());
		//request.getRequestDispatcher("123").forward(request, response);
		//response.sendRedirect(request.getContextPath());
		//response.sendRedirect(request.getContextPath()+"www.hao123.com");
		return super.preHandle(request, response, handler);
	}
}
