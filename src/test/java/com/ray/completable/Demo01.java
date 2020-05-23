package com.ray.completable;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Package:com.ray.completable
 * *Author:ray
 * *version:...
 * *Created in 2019/12/5  22:30
 **/
public class Demo01 {
	public static void main(String[] args) {


		ExecutorService executorService = Executors.newCachedThreadPool();
		for (int i = 0; i < 100; i++) {
			final int num=i;
			executorService.submit(()->{

				System.out.println(Thread.currentThread().getName());
				return num;
			});
		}
		//executorService.shutdown();
	}
}
