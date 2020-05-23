package com.ray.educatesystem.controller.limitvisit;

import com.google.common.util.concurrent.RateLimiter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;

/**
 * Package:com.ray.educatesystem.controller
 * *Author:ray
 * *version:...
 * *Created in 2020/2/16  22:01
 **/
@RestController
public class LimitVisitController1 {

	RateLimiter limiter=RateLimiter.create(0.2);

	@Resource(name="ray")
	private ExecutorService executorService;

	private CountDownLatch countLock =new CountDownLatch(5);

	@GetMapping("limit")
	public String testPropagate(){
		Boolean check = LimitUtil.check();
		if (check) {
			return "调用成功";
		}
		return "稍后";
	}


	@GetMapping("limitg")
	public String testLimit(){
		if (limiter.tryAcquire()) {
			return "调用成功";
		}
		return "稍后";
	}

	@GetMapping("limitt")
	public String testLockLimit(){
		if (limiter.tryAcquire()) {
			return "调用成功";
		}
		return "稍后";
	}
}
