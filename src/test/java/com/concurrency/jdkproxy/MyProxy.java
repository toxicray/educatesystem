package com.concurrency.jdkproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Package:com.concurrency.jdkproxy
 * *Author:ray
 * *version:...
 * *Created in 2020/1/19  22:44
 **/
public class MyProxy {

	public static void main(String[] args) {
		final ProducerImpl producer=new ProducerImpl();


		Producer o = (Producer)Proxy.newProxyInstance(producer.getClass().getClassLoader(), producer.getClass().getInterfaces(), new InvocationHandler() {
			@Override
			public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

				//args是方法参数数组
				//method是调用方法

				return null;
			}
		});
	}
}
