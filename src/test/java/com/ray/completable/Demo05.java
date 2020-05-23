package com.ray.completable;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * Package:com.ray.completable
 * *Author:ray
 * *version:...
 * *Created in 2019/12/5  23:55
 **/
public class Demo05 {
	public static void main(String[] args) throws ExecutionException, InterruptedException {
		CompletableFuture<String> task1=CompletableFuture.supplyAsync(()->{
			System.out.println(Thread.currentThread().getName());
			int num=5/0;
			return "hello";
		}).exceptionally((e)->{
			System.out.println(e.getMessage());
			return "哈哈";
		}).whenComplete((t,e)->{
			System.out.println(t+e+"12");
		});
		System.out.println(task1.get());
	}
}
