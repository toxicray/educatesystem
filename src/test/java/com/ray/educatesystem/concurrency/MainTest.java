package com.ray.educatesystem.concurrency;

/**
 * Package:com.ray.educatesystem.concurrency
 * *Author:ray
 * *version:...
 * *Created in 2020/1/17  0:22
 **/
public class MainTest {
	public static void main(String[] args) {
		doWhat( ()->{
			System.out.println("吃饭");
		});
	}
	private static void doWhat( functionInterface functionInterface) {
		functionInterface.doSomthing();
	}
}
