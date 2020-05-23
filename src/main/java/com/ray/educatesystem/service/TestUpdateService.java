package com.ray.educatesystem.service;

import com.ray.educatesystem.dto.Test1;
import com.ray.educatesystem.mapper.Test1Mapper;
import org.apache.ibatis.annotations.Update;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import java.sql.SQLIntegrityConstraintViolationException;

/**
 * Package:com.ray.educatesystem.service
 * *Author:ray
 * *version:...
 * *Created in 2020/3/9  0:54
 **/
@Service
public class TestUpdateService {

	@Autowired
	private Test1Mapper test1Mapper;

	@Transactional
	public String testUpdate(Test1 test1){
		Test1 test= new Test1();
		test.setTest(10101);
		Example example =new Example(Test1.class);
		Example.Criteria criteria = example.createCriteria();
		criteria.andEqualTo("sequence",0);
		int i = test1Mapper.updateByExampleSelective(test,example);
		System.out.println(i);

		try {
			int insert = test1Mapper.insert(test1);
			System.out.println(insert);
		}catch (Exception e){
			if (e instanceof SQLIntegrityConstraintViolationException){
				throw new IllegalArgumentException("已经执行");
			}else {
				throw e;
			}
		}

		return null;
	}
}
