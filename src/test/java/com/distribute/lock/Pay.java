package com.distribute.lock;

/**
 * Package:com.distribute.lock
 * *Author:ray
 * *version:...
 * *Created in 2020/3/12  19:04
 **/
public class Pay {

	public void pay(){
		System.out.println(Thread.currentThread().getName()+"支付成功");
	}
}
