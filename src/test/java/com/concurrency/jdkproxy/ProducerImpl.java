package com.concurrency.jdkproxy;

/**
 * Package:com.concurrency.jdkproxy
 * *Author:ray
 * *version:...
 * *Created in 2020/1/19  22:48
 **/
public class ProducerImpl implements Producer {
	@Override
	public void saleProduct(float money) {
		System.out.println("销售产品,并拿到钱!"+money);
	}

	@Override
	public void afterService(float money) {
		System.out.println("提供售后服务,拿到钱"+money);
	}
}
