package com.concurrency;

/**
 * Package:com.concurrency
 * *Author:ray
 * *version:...
 * *Created in 2020/1/16  0:33
 **/
public class VolatileExample {

	int x =0;
	volatile boolean v=false;

	public void writer(){
		x=42;
		v=true;
	}
	public void reader(){
		if (v){
			System.out.println(x);
		}
	}
}
