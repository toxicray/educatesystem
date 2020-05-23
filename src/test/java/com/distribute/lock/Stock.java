package com.distribute.lock;

/**
 * Package:com.distribute.lock
 * *Author:ray
 * *version:...
 * *Created in 2020/3/12  19:02
 **/
public class Stock {

	private  static Integer count =1;

	public synchronized boolean reduceStock(){
		if (count>0) {
			count--;
			return true;
		}
		return false;
	}

}
