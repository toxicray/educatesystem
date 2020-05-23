package com.ray.educatesystem.concurrency;

/**
 * Package:com.ray.educatesystem.concurrency
 * *Author:ray
 * *version:...
 * *Created in 2019/12/26  21:49
 **/
public class ThreadDemo01 {
	public static void main(String[] args) {
		for (int i = 0; i < 1000000; i++) {
			new Thread(() -> {
				try {
					Thread.sleep(100000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}).start();
		}

	}
}
