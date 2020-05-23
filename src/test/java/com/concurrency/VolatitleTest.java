package com.concurrency;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Package:com.concurrency
 * *Author:ray
 * *version:...
 * *Created in 2020/1/15  22:38
 **/
public class VolatitleTest {

	private static volatile int num=0;

	private static final int count=1000;

	private static final int client=20;

	public static void main(String[] args) throws InterruptedException {

		ExecutorService pool = Executors.newCachedThreadPool();
		CountDownLatch count=new CountDownLatch(1000);

		for (int i = 0; i < 1000; i++) {
			pool.execute(()->{
				increLockNum();
				count.countDown();
			});
		}
		count.await();
		pool.shutdown();
		System.out.println(num);
	}
	private static void increNum(){
		num++;
	}
	private synchronized static void increLockNum(){
		num++;
	}
}
