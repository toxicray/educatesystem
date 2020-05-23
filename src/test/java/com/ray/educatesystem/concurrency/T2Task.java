package com.ray.educatesystem.concurrency;

import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

/**
 * Package:com.ray.educatesystem.concurrency
 * *Author:ray
 * *version:...
 * *Created in 2019/11/17  12:46
 **/
class  T2Task implements Callable {

	@Override
	public Object call() throws Exception {
		System.out.println(Thread.currentThread().getName());

		System.out.println("T2: 洗茶壶");
		TimeUnit.SECONDS.sleep(1);

		System.out.println("洗茶杯");
		TimeUnit.SECONDS.sleep(2);

		System.out.println("T2: 拿茶叶");
		return "铁观音";
	}
}
