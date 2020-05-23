package com.ray.completable.pool;

import java.util.concurrent.ThreadFactory;

/**
 * Package:com.ray.completable.pool
 * *Author:ray
 * *version:...
 * *Created in 2020/1/16  23:50
 **/
public class MyThreadFactory implements ThreadFactory {
	@Override
	public Thread newThread(Runnable r) {
		Thread thread=new Thread(r,"custom"+r.hashCode());
		return thread;
	}
}
