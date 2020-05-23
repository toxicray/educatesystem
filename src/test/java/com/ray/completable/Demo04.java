package com.ray.completable;

import com.sun.xml.internal.ws.util.CompletedFuture;

import java.util.concurrent.*;

/**
 * Package:com.ray.completable
 * *Author:ray
 * *version:...
 * *Created in 2019/12/5  22:58
 **/
public class Demo04 {
	public static void main(String[] args) throws ExecutionException, InterruptedException {
		ThreadPoolExecutor pool = new ThreadPoolExecutor(5,
				10,
				60,
				TimeUnit.SECONDS,
				new LinkedBlockingQueue<>(10),
				r -> new Thread(r, "ray" + r.hashCode()),
				(r, q) -> {
					System.out.println("拒绝策略");
				});

		CompletableFuture<Void> voidCompletableFuture = CompletableFuture.runAsync(() -> {
			System.out.println(Thread.currentThread().getName());
		},pool).thenRun(() -> {
			System.out.println(Thread.currentThread().getName());
		}).thenRunAsync(() -> {
			System.out.println(Thread.currentThread().getName());
		},pool);
		voidCompletableFuture.get();
		pool.shutdown();
	}
}
