package com.concurrency;

/**
 * Package:com.concurrency
 * *Author:ray
 * *version:...
 * *Created in 2020/1/15  22:51
 **/
public class CpuCacheTest {
	private static volatile Integer Counter = 0;

	public static void main(String[] args) {
		new changeListener().start();
		new Changer().start();
	}

	static class changeListener extends Thread {
		@Override
		public void run() {
			int threadValue = Counter;
			while (threadValue < 5) {
				if (threadValue != Counter) {
					System.out.println("改变值" + threadValue);
					threadValue = Counter;
				}
			}
		}
	}

	static class Changer extends Thread {

		Integer threadValue = Counter;

		@Override
		public void run() {
			while (threadValue < 5) {
				System.out.println("添加值: "+threadValue);
				Counter=++threadValue;
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
