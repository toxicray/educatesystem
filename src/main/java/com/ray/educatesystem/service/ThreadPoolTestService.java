package com.ray.educatesystem.service;

import com.ray.educatesystem.dto.Test1;
import com.ray.educatesystem.mapper.Test1Mapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.task.TaskExecutor;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

import javax.annotation.Resource;
import java.util.Date;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;

/**
 * Package:com.ray.educatesystem.service
 * *Author:ray
 * *version:...
 * *Created in 2020/2/16  18:55
 **/
@Service
public class ThreadPoolTestService {

	private static final Logger LOG=LoggerFactory.getLogger(ThreadPoolTestService.class);

	@Autowired
	private Test1Mapper test1Mapper;

	@Async("tyrion")
	public void testAsync() {
		System.out.println(Thread.currentThread().getName());
	}

	@Autowired
	private TaskExecutor taskExecutor;

	@Resource(name="tyrion")
	private ExecutorService pool1;

	@Resource(name="ray")
	private ExecutorService pool2;


	@Autowired
	private TransactionTemplate transactionTemplate;

	public void testCustomAsync() {
		taskExecutor.execute(()->{
			System.out.println("----------------------------");
			System.out.println(Thread.currentThread().getName());
		});

		pool2.execute(()->{
			System.out.println("----------------------------");
			System.out.println(Thread.currentThread().getName());
		});

		pool1.execute(()->{
			System.out.println("----------------------------");
			System.out.println(Thread.currentThread().getName());
		});
	}

	@Transactional(rollbackFor = Exception.class)
	public String testAsyncCustomAsync() {
		CompletableFuture future=CompletableFuture.runAsync(()->{
			new TransactionCallbackWithoutResult() {
				@Override
				protected void doInTransactionWithoutResult(TransactionStatus status) {
					try {
						Thread.sleep(2000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					Test1 test1=new Test1();
					test1.setName("异步任务");
					test1.setCount(101);
					test1.setCreateTime(new Date());
					test1Mapper.insert(test1);
				}
			};
		},pool2);

		Test1 test1=new Test1();
		test1.setName("同步任务");
		test1.setCount(222);
		test1.setCreateTime(new Date());
		test1Mapper.insert(test1);
		if (true){
			throw  new IllegalArgumentException("异常");
		}

		return "成功";
	}
}
