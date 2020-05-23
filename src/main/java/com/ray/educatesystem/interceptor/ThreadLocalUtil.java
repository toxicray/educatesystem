package com.ray.educatesystem.interceptor;

import org.springframework.stereotype.Component;

/**
 * Package:com.ray.educatesystem.interceptor
 * *Author:ray
 * *version:...
 * *Created in 2020/3/26  0:16
 **/
@Component
public class ThreadLocalUtil {

	public static ThreadLocal<Integer> local = new ThreadLocal<>();


}
