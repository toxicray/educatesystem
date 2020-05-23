package com.ray.completable.串行;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * Package:com.ray.completable.串行
 * *Author:ray
 * *version:...
 * *Created in 2019/12/17  21:12
 **/
public class Demo02 {
	public static void main(String[] args) throws ExecutionException, InterruptedException {

		CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> {
			printName();
			return "hello";
		}).thenApply((v) -> {
					printName();
					return v + "world";
				}
		);

		System.out.println(future.get());

	}
	private static void printName() {
		System.out.println(Thread.currentThread().getName());
	}
}
