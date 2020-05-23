package com.ray.educatesystem.service;

import com.ray.educatesystem.dto.Test1;
import com.ray.educatesystem.mapper.Test1Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

/**
 * Package:com.ray.educatesystem.service
 * *Author:ray
 * *version:...
 * *Created in 2019/11/8  20:39
 **/
@Service
public class TestTransactionPropagaService {

	@Autowired
	private Test1Mapper test1Mapper;

	public void 																	testOuterTransaction(){
		testInnnerTransaction();
	}

	@Transactional
	public void testInnnerTransaction(){
		Test1 test1=new Test1();
		test1.setName("事务嵌套测试");
		test1.setCount(101);
		test1.setCreateTime(new Date());
		test1Mapper.insert(test1);
		throw new IllegalArgumentException("抛个异常");
	}
}
