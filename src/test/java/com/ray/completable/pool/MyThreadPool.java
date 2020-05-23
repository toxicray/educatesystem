package com.ray.completable.pool;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Package:com.ray.completable.pool
 * *Author:ray
 * *version:...
 * *Created in 2020/1/16  23:05
 **/
public class MyThreadPool {
	public static void main(String[] args) {
		ThreadPoolExecutor threadPoolExecutor=new ThreadPoolExecutor(5,
				10,
				60,
				TimeUnit.SECONDS,
				new LinkedBlockingQueue<>(10),
				r-> new Thread(r,"ray"+r.hashCode()),
				(r,q)->{
					System.out.println("拒绝策略");
				});
		for (int i = 0; i < 17; i++) {
			threadPoolExecutor.execute(()->{
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println(Thread.currentThread().getName());
			});
		}
		System.out.println(threadPoolExecutor.getPoolSize());
		//threadPoolExecutor.shutdown();
		threadPoolExecutor.shutdownNow();
	}
}
