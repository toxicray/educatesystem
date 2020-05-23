package com.ray.completable;

import java.util.ArrayList;

/**
 * Package:com.ray.completable
 * *Author:ray
 * *version:...
 * *Created in 2019/12/6  0:43
 **/
public class Demo {

	public synchronized void method1() {

	}

	public void method2() {

	}

	public static void main(String[] args) {
		ArrayList<Long> result1 =new ArrayList<>();//记录完全遍历
		ArrayList<Long> result2 =new ArrayList<>();//记录跳跃遍历
		int[] arr = new int[128 * 1024 * 1024];
		for (int i = 0; i < 10; i++) {
			long stamp1 = System.currentTimeMillis();
			for (int j = 0; j < arr.length; j++) {
				arr[j] *= 3;
			}
			long stamp2 = System.currentTimeMillis();
			for (int k = 0; k < arr.length; k += 48) {
				arr[k] *= 3;
			}
			long stamp3 = System.currentTimeMillis();
			result1.add(stamp2-stamp1);
			result2.add(stamp3-stamp2);
		}
		Long total = result1.stream().reduce(0L, (a,b)->a+b);
		Long total1 = result2.stream().reduce(0L, (a,b)->a+b);
		result1.forEach(t->{
			System.out.print(t+" ");
		});
		System.out.println();
		System.out.println("-------------");
		result2.forEach(t->{
			System.out.print(t+" ");
		});
	}
}
