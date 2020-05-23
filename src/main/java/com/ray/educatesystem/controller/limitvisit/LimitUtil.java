package com.ray.educatesystem.controller.limitvisit;

import java.util.Date;

/**
 * Package:com.ray.educatesystem.controller.limitvisit
 * *Author:ray
 * *version:...
 * *Created in 2020/2/16  22:02
 **/
public class LimitUtil {

	private static ThreadLocal<Long> map =new ThreadLocal<>();


	public static Boolean check(){
		Long before = map.get();
		if (before != null) {
			if (System.currentTimeMillis()-before>2000000) {
				map.set(System.currentTimeMillis());
				return true;
			}else{
				map.set(System.currentTimeMillis());
				return false;
			}
		}
		map.set(System.currentTimeMillis());
		return true;
	}

}
