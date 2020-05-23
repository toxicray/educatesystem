package com.ray.educatesystem.controller;

import com.ray.educatesystem.rocketmq.producer.MqProducr;
import org.apache.rocketmq.client.exception.MQBrokerException;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.remoting.exception.RemotingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

/**
 * Package:com.ray.educatesystem.controller
 * *Author:ray
 * *version:...
 * *Created in 2020/3/21  20:32
 **/
@RestController
public class MqTestController {

	//@Autowired
	private MqProducr producr;

	/**
	 * topic,消息依赖于topic
	 */
	private static final String topic = "pay_test_topic";

	@GetMapping("/mq")
	public Object callback(String text) throws InterruptedException, RemotingException, MQClientException, MQBrokerException {
		// 创建消息  主题   二级分类   消息内容好的字节数组
		Message message = new Message(topic, "taga", ("hello rocketMQ " + text).getBytes());

		SendResult send = producr.getProducer().send(message);

		System.out.println(send);

		return new HashMap<>();
	}
}
