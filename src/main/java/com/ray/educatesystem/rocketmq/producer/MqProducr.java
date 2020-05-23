package com.ray.educatesystem.rocketmq.producer;

import com.ray.educatesystem.rocketmq.config.JmsConfig;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.springframework.stereotype.Component;

/**
 * Package:com.ray.educatesystem.rocketmq.producer
 * *Author:ray
 * *version:...
 * *Created in 2020/3/21  20:24
 **/

public class MqProducr {

	//生产组,生产者必须在生产者组内
	private String producerGroup = "pay_group";

	private String nameServer = "localhost:9876";

	private DefaultMQProducer producer;

	public MqProducr() {
		this.producer = new DefaultMQProducer(producerGroup);
		producer.setNamesrvAddr(JmsConfig.NAME_SERVER);
		start();
	}

	public DefaultMQProducer getProducer() {
		return producer;
	}

	public void start(){
		try {
			this.producer.start();
		} catch (MQClientException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 一般在应用上下文,使用上下文监听器,进行关闭
	 */
	public void shutdown() {
		producer.shutdown();
	}

}
