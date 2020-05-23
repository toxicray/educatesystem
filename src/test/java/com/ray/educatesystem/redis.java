package com.ray.educatesystem;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

/**
 * Package:com.ray.educatesystem
 * *Author:ray
 * *version:...
 * *Created in 2019/11/21  23:40
 **/
public class redis {
	public static void main(String[] args) throws ExecutionException, InterruptedException {
		//FutureTask<String> task=new FutureTask<String>(()->{
		//	System.out.println(Thread.currentThread().getName());
		//	return Thread.currentThread().getName();
		//});
		//new Thread(task).run();
		//System.out.println(task.get());



		CompletableFuture<String> completableFuture = new CompletableFuture<>();

		Executors.newCachedThreadPool().submit(() -> {
			Thread.sleep(500);
			completableFuture.complete("Hello");
			return null;
		});
		System.out.println(completableFuture.get());
	}
}
