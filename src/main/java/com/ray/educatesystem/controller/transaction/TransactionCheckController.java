package com.ray.educatesystem.controller.transaction;

import com.ray.educatesystem.service.transaction.TransctionCheckService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Package:com.ray.educatesystem.controller.transaction
 * *Author:ray
 * *version:...
 * *Created in 2020/2/26  12:57
 **/
@RequestMapping("/transaction")
public class TransactionCheckController {

	@Autowired
	private TransctionCheckService transctionCheckService;

	/**
	 * 非事务方法调用本类的事务方法   抛异常(分为运行时异常,非运行时异常)
	 * @return
	 */
	@GetMapping("one")
	public String testPropagate1(){
		transctionCheckService.noneToExist();
		return "调用成功";
	}

	/**
	 * 事务方法调用本类的非事务方法   抛异常
	 * 同类的非事务方法
	 * @return
	 */
	@GetMapping("two")
	public String testPropagate2(){
		transctionCheckService.existToNone();
		return "调用成功";
	}


	/**
	 * 调用异步方法是否生效
	 * @return
	 */
	@GetMapping("three")
	public String testAsyncPropagate3(){
		transctionCheckService.async();
		return "调用成功";
	}

}
