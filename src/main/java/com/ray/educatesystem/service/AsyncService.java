package com.ray.educatesystem.service;

import com.ray.educatesystem.dto.Test1;
import com.ray.educatesystem.mapper.Test1Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

import java.util.Date;

/**
 * Package:com.ray.educatesystem.service
 * *Author:ray
 * *version:...
 * *Created in 2019/10/31  20:57
 **/
@Service
public class AsyncService {

	@Autowired
	private Test1Mapper test1Mapper;

	@Autowired
	private TransactionTemplate transactionTemplate;

	//@Async
	@Transactional(propagation = Propagation.NOT_SUPPORTED)
	public void insertOne(){
		Test1 test1=new Test1();
		test1.setCount(100);
		test1.setCreateTime(new Date());
		test1.setId(100);
		test1.setName("先");
		test1Mapper.insert(test1);
		transactionTemplate.execute(new TransactionCallbackWithoutResult() {
			@Override
			protected void doInTransactionWithoutResult(TransactionStatus status) {
				test1Mapper.insert(test1);
			}
		});
		System.out.println("插入完成!");
	}


	@Transactional(propagation = Propagation.NOT_SUPPORTED)
	public void insertOneAnother(){
		Test1 test1=new Test1();
		test1.setCount(100);
		test1.setCreateTime(new Date());
		test1.setId(100);
		test1.setName("先");
		test1Mapper.insert(test1);
	}
}
