package com.ray.completable;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * Package:com.ray.completable
 * *Author:ray
 * *version:...
 * *Created in 2019/12/5  22:49
 **/
public class Demo03 {
	public static void main(String[] args) throws ExecutionException, InterruptedException {

		CompletableFuture<String> task1=CompletableFuture.supplyAsync(()->{
			System.out.println(Thread.currentThread().getName());
			return "hello";
		});

		CompletableFuture<String> task2=CompletableFuture.supplyAsync(()->{
			System.out.println(Thread.currentThread().getName());
			return " world";
		});
		CompletableFuture<String> future=task1.thenCombine(task2,(v1,v2)->{
			return v1.toUpperCase()+v2.toUpperCase();
		});
		System.out.println(future.get());
	}
}
