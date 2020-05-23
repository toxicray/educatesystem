package com.ray.completable;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * Package:com.ray.completable
 * *Author:ray
 * *version:...
 * *Created in 2019/12/17  20:23
 **/
public class Demo08 {
	public static void main(String[] args) throws ExecutionException, InterruptedException {
		CompletableFuture<Integer> completableFuture = CompletableFuture.supplyAsync(() -> {
			printName();
			int i=1/0;
			return 1;
		}).whenComplete((n, e) -> {
			printName();
		}).whenCompleteAsync((n, e) -> {
			printName();
		}).exceptionally((n)->{
			printName();
			System.out.println(n.getMessage());
			return 2;
		});
		System.out.println(completableFuture.get());
	}

	private static void printName() {
		System.out.println(Thread.currentThread().getName());
	}
}
