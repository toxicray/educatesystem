package com.ray.educatesystem.concurrency;

/**
 * Package:com.ray.educatesystem.concurrency
 * *Author:ray
 * *version:...
 * *Created in 2020/1/17  0:36
 **/
public class TestCode {
	public void method() {
		int a=1;
		int b=2;
	}

	public void methodlock() {
		synchronized (this){
			int a=1;
			int b=2;
		}
	}
}
