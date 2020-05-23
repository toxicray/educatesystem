package com.ray.completable;

import java.util.concurrent.*;

/**
 * Package:com.ray.completable
 * *Author:ray
 * *version:...
 * *Created in 2019/12/6  0:25
 **/
public class Demo06 {
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		ExecutorService pool = Executors.newFixedThreadPool(3);
		long l = System.currentTimeMillis();
		CompletionService<Integer> service = new ExecutorCompletionService<>(pool);
		service.submit(() -> {
			Thread.sleep(1000);
			return 3;
		});
		service.submit(() -> {
			Thread.sleep(2000);
			return 2;
		});
		service.submit(() -> {
			Thread.sleep(3000);
			return 1;
		});
		for (int i = 0; i < 3; i++) {
			System.out.println(service.take().get());
			break;
		}

		System.out.println(System.currentTimeMillis()-l);
		pool.shutdown();
	}
}

