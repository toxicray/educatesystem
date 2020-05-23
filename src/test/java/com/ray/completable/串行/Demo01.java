package com.ray.completable.串行;

import java.util.concurrent.CompletableFuture;

/**
 * Package:com.ray.completable.串行
 * *Author:ray
 * *version:...
 * *Created in 2019/12/17  20:48
 **/
public class Demo01 {
	public static void main(String[] args) {
		CompletableFuture<Void> voidCompletableFuture = CompletableFuture.supplyAsync(() -> {
			printName();
			return "hello";
		}).thenAccept(
				(v) -> {
					printName();
				}
		);


	}

	private static void printName() {
		System.out.println(Thread.currentThread().getName());
	}
}
