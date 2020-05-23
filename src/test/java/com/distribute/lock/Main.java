package com.distribute.lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Package:com.distribute.lock
 * *Author:ray
 * *version:...
 * *Created in 2020/3/12  19:05
 **/
public class Main {
	static Lock lock = new ReentrantLock();

	static ZkLock distributeLock = new ZkLock();

	public static void main(String[] args) {
		Thread thread1 = new Thread(new UserThread(),"user1");
		Thread thread2 = new Thread(new UserThread(),"user2");
		thread1.start();
		thread2.start();
	}
	static class UserThread implements Runnable{

		@Override
		public void run() {
			new Order().createOrder();
			distributeLock.lock();
			boolean flag = new Stock().reduceStock();
			distributeLock.unlock();
			if (flag) {
				new Pay().pay();
				System.out.println("减库存成功");
			}else{
				System.out.println("减库存失败");
			}
		}
	}
}
