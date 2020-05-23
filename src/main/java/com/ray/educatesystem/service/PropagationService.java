package com.ray.educatesystem.service;

import com.ray.educatesystem.dto.Teacher;
import org.springframework.aop.framework.AopContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Package:com.ray.educatesystem.service
 * *Author:ray
 * *version:...
 * *Created in 2020/1/10  0:15
 **/
@Service
public class PropagationService {

	@Transactional
	public void insertList(){
		PropagationService o = (PropagationService)AopContext.currentProxy();
		o.insertList1();
		System.out.println(this.toString());
	}

	public void insertList1(){
		System.out.println(this.toString());
	}

}
