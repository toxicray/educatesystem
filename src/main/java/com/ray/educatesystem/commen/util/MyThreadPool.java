package com.ray.educatesystem.commen.util;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Package:com.ray.educatesystem.commen.util
 * *Author:ray
 * *version:...
 * *Created in 2020/2/16  19:57
 **/
@Configuration
public class MyThreadPool {

	@Bean(name = "ray")
	public ExecutorService getMyPool(){
		return new ThreadPoolExecutor(
		1,
		1,
		60,
			TimeUnit.SECONDS,
			new LinkedBlockingQueue<>(1),
			r->new Thread(r,"custom1"),
				(q,r)->{

				}
		);
	}


	@Bean(name = "tyrion")
	public ExecutorService getMyAnotherPool(){
		return new ThreadPoolExecutor(
				5,
				5,
				60,
				TimeUnit.SECONDS,
				new LinkedBlockingQueue<>(10),
				r->new Thread(r,"custom2"),
				(q,r)->{

				}
		);
	}



}
