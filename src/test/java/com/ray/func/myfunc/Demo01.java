package com.ray.func.myfunc;

/**
 * Package:com.ray.func.myfunc
 * *Author:ray
 * *version:...
 * *Created in 2020/1/27  11:00
 **/
public class Demo01 {
	public static void main(String[] args) {
		doSomething(()->{
			System.out.println(123);
		return"哈哈";
		});
	}

	private static void doSomething(MyFunction function) {
		function.doSomething();
	}
}
