package com.concurrency.jdkproxy;

/**
 * Package:com.concurrency.jdkproxy
 * *Author:ray
 * *version:...
 * *Created in 2020/1/19  22:46
 **/
public interface Producer {

	/**
	 *@Description 提供服务
			* @Param 销售
			* @return 
			**/
	public void saleProduct(float money);

	/**
	 *@Description 
			* @Param
			* @return 
			**/
	public void afterService(float money);
}
