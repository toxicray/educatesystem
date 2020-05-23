package com.concurrency;

/**
 * Package:com.concurrency
 * *Author:ray
 * *version:...
 * *Created in 2020/1/15  21:54
 **/
public class SingleTon {

	//volatile
	private static SingleTon singleInstance;

	private SingleTon() {
	}
	//1、分配一个区域
	//2、对应区域上初始化对象
	//3、然后将内存区域指向引用  singleInstance
	//万一编译器优化一下?
	public static SingleTon getSingleInstance(){
		if (singleInstance != null){
			synchronized (SingleTon.class){
				if (singleInstance != null) {
					singleInstance=new SingleTon();
				}
			}
		}
		return singleInstance;
	}
}
