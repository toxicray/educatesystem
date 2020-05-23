package com.distribute.lock;

/**
 * Package:com.distribute.lock
 * *Author:ray
 * *version:...
 * *Created in 2020/3/12  19:01
 **/
public class Order {

	public void createOrder(){
		System.out.println(Thread.currentThread().getName()+"创建订单!");
	}
}
