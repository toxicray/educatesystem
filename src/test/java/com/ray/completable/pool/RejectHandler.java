package com.ray.completable.pool;

import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * Package:com.ray.completable.pool
 * *Author:ray
 * *version:...
 * *Created in 2020/1/16  23:08
 **/
public class RejectHandler implements RejectedExecutionHandler {
	@Override
	public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
		System.out.println(executor.getPoolSize());
		System.out.println("拒绝执行任务了");
	}
}
