package com.ray.educatesystem.zookeeper;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.apache.zookeeper.CreateMode;

import java.util.List;

/**
 * Package:com.ray.educatesystem.zookeeper
 * *Author:ray
 * *version:...
 * *Created in 2019/10/25  23:03
 **/
public class CuratorDemo {

	final static String zookeeperAddr="127.0.0.1:2181";

	public static void main(String[] args) throws Exception {
		CuratorFramework curatorClient= CuratorFrameworkFactory.builder()
				.connectString(zookeeperAddr)//zkCLient
				.connectionTimeoutMs(10000)//连接超时时间
				.sessionTimeoutMs(60000)
				.retryPolicy(new ExponentialBackoffRetry(1000, 3))
				//.namespace("myZookeeperTest")
				.build();
		curatorClient.start();
		//curatorClient.create().forPath("/path");//默认持久化节点,以斜杠开头
		//System.out.println(curatorClient.getChildren().forPath("/"));
		curatorClient.create()
				//.withMode(CreateMode.EPHEMERAL)
				.forPath("/secondPath","hello word".getBytes());

		//获取zokkeper的数据
		System.out.println(curatorClient.getData().forPath("/secondPath").length);


		//递归创建子节点
		curatorClient
				.create()
				.creatingParentContainersIfNeeded()
				.forPath("/secondPath/second2");


		List<String> strings = curatorClient.getChildren().forPath("/secondPath");
		strings.stream().forEach(str->{
			System.out.println(str);
		});



	}
}
