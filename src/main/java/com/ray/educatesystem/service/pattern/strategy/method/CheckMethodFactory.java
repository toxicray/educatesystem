package com.ray.educatesystem.service.pattern.strategy.method;


import com.ray.educatesystem.service.pattern.strategy.CheckMethod;

import java.util.HashMap;

/**
 * Package:com.ray.educatesystem.service.pattern.strategy.method
 * *Author:ray
 * *version:...
 * *Created in 2020/2/16  21:08
 **/
public class CheckMethodFactory {

	private static final HashMap<String, CheckMethod> map = new HashMap<>();

	static {
		map.put(checkKey.mustCheck,new MustCheck());
		map.put(checkKey.shouldCheck,new ShouldCheck());
		map.put(checkKey.noCheck,new NoCheck());
	}

	public static CheckMethod getCheckMethod(String str) {
		return map.get(str) == null ? new DefaultCheck() : map.get(str);
	}

	private interface checkKey {
		final String mustCheck = "must";
		final String shouldCheck = "should";
		final String noCheck = "noCheck";
	}
}
