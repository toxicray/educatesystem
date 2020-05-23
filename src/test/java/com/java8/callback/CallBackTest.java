package com.java8.callback;

/**
 * Package:com.java8.callback
 * *Author:ray
 * *version:...
 * *Created in 2020/3/6  1:37
 **/
public class CallBackTest {
	public static void main(String[] args) {
		String str = "tyrion";

		testCallBack(str,(string)->{
			System.out.println(string);
			return null;
		});
	}

	private static void testCallBack(String str,CallBackDemo callBackDemo) {
		System.out.println(str);
		callBackDemo.call("ray");
	}
}
