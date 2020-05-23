package com.ray.educatesystem.concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Package:com.ray.educatesystem.concurrency
 * *Author:ray
 * *version:...
 * *Created in 2019/12/26  21:37
 **/
public class ThreadPoolDemo {

	public static void main(String[] args) {

		ExecutorService es = new ThreadPoolExecutor( 50,
				500,
				60L,
				TimeUnit.SECONDS, //注意要创建有界队列
				 new LinkedBlockingQueue(2000),
				r->{ return new Thread(r, "echo-"+ r.hashCode()); },
				(r,e)->{
					System.out.println("受不了了");
				});
		es.submit(new Demo());
		es.shutdown();
	}


	static class Demo implements Runnable{
		@Override
		public void run() {
			System.out.println(Thread.currentThread().getName());
		}
	}
}
