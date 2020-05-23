package com.ray.educatesystem.service;

import com.ray.educatesystem.commen.annotation.Audit;
import com.ray.educatesystem.commen.exception.ValidateException;
import com.ray.educatesystem.dto.Test1;
import com.ray.educatesystem.dto.Test2;
import com.ray.educatesystem.mapper.Test1Mapper;
import com.ray.educatesystem.mapper.Test2Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

import java.util.Date;

@Service
//@Transactional
public class TransactionService {

	@Autowired
	private TransactionTemplate transactionTemplate;

	@Autowired
	private Test1Mapper mapper1;

	@Autowired
	private Test2Mapper mapper2;

	@Autowired
	private AsyncService asyncService;

	@Transactional
	public void addTest1(){
		System.out.println(this.toString());
		Test1 test1=new Test1();
		test1.setName("tyrion");
		test1.setCount(100);
		test1.setCreateTime(new Date());
		mapper1.insert(test1);
		transactionTemplate.execute(new TransactionCallbackWithoutResult() {
			@Override
			protected void doInTransactionWithoutResult(TransactionStatus status) {
				test1.setId(100);
				test1.setName("ray");
				mapper1.insert(test1);
			}
		});

		System.out.println(mapper1.selectByPrimaryKey(100));
		System.out.println("插入完成!");
		throw new IllegalArgumentException("过程异常");
	}


	@Transactional
	public void addTestAnother(){
		Test1 test1=new Test1();
		test1.setName("后");
		test1.setCount(100);
		test1.setCreateTime(new Date());
		mapper1.insert(test1);
		asyncService.insertOne();
		//asyncService.insertOneAnother();
		System.out.println(mapper1.selectByPrimaryKey(100));
		System.out.println("插入完成!");
		throw new IllegalArgumentException("异常");
	}
	













	//@Transactional
	//@Transactional(propagation = Propagation.REQUIRES_NEW)
	public void addTest2(){
		Test2 test2=new Test2();
		test2.setName("tyrion");
		test2.setCount(100);
		test2.setCreateTime(new Date());
		mapper2.insert(test2);
		if(true) {
			throw new RuntimeException("数据异常");
		}
	}

	@Transactional(propagation = Propagation.NOT_SUPPORTED)
	public void addTest3(){
		Test2 test2=new Test2();
		test2.setName("tyrion");
		test2.setCount(100);
		test2.setCreateTime(new Date());
		mapper2.insert(test2);
		throw new IllegalArgumentException("哈哈");
	}

	@Audit(name = "#{name}",action = "哈哈")
	public void addTestAsc(Test1 test1) {

	}

	public Test1 getTest1ById(Integer id) {
		Test1 test1 = mapper1.selectByPrimaryKey(100);
		return test1;
	}
}
