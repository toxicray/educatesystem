package com.ray.educatesystem.concurrency;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

/**
 * Package:com.ray.educatesystem.concurrency
 * *Author:ray
 * *version:...
 * *Created in 2019/11/17  12:45
 **/
class T1Task implements Callable {
	FutureTask<String> ft2;

	public T1Task(FutureTask<String> ft2) {
		this.ft2 = ft2;
	}

	@Override
	public Object call() throws Exception {
		System.out.println(Thread.currentThread().getName());

		System.out.println("T!: 洗水壶");
		TimeUnit.SECONDS.sleep(1);

		System.out.println("T1: 烧开水");
		TimeUnit.SECONDS.sleep(3);

		String tea = ft2.get();
		System.out.println("T1: 拿到茶叶,开始泡茶");
		TimeUnit.SECONDS.sleep(2);

		return "上茶"+tea;
	}
}
