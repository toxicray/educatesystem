package com.ray.completable;

import java.util.LinkedList;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Package:com.ray.completable
 * *Author:ray
 * *version:...
 * *Created in 2019/12/11  23:56
 **/
public class Demo07 {
	public static void main(String[] args) throws ExecutionException, InterruptedException {
		ExecutorService pool = Executors.newCachedThreadPool();
		CompletableFuture<Integer> completableFuture=CompletableFuture.supplyAsync(()->{
			System.out.println(Thread.currentThread().getName());
			return 1;
		},pool);
		Integer join = completableFuture.join();
		//System.out.println(join);


		CompletableFuture<Object> future = CompletableFuture.anyOf(completableFuture).whenComplete((t, v) -> {
			System.out.println(t);
			System.out.println(v);
		});
		System.out.println(future.get());

	}
}
