package com.ray.completable;


import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ForkJoinPool;

/**
 * Package:com.ray.completable
 * *Author:ray
 * *version:...
 * *Created in 2019/12/5  22:41
 **/
public class Demo02 {
	public static void main(String[] args) {
		//
		//List<Integer> list=new LinkedList<>();
		//list.add(1);
		//list.add(2);
		//list.add(3);
		//list.add(4);
		//list.add(5);
		//list.stream().parallel().forEach(t->{
		//	System.out.println(t);
		//	try {
		//		Thread.sleep(1000);
		//	} catch (InterruptedException e) {
		//		e.printStackTrace();
		//	}
		//	System.out.println(Thread.currentThread().getName());
		//});
		ForkJoinPool forkJoinPool=new ForkJoinPool(4);
		System.out.println(forkJoinPool.getPoolSize());
	}
}
