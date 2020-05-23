package com.ray.educatesystem.filter;

import com.ray.educatesystem.interceptor.LoginInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * Package:com.ray.educatesystem.filter
 * *Author:ray
 * *version:...
 * *Created in 2020/2/17  9:38
 **/
@Configuration
public class WebConfig implements WebMvcConfigurer {

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(new MyIntercepter()).addPathPatterns("/**");
		registry.addInterceptor(new LoginInterceptor()).addPathPatterns("/**");
	}

	@Bean
	public MyIntercepter getMyInterceptor(){
		return new MyIntercepter();
	}
}
