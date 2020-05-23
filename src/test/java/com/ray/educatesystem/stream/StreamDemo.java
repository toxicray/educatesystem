package com.ray.educatesystem.stream;

import org.apache.curator.RetryPolicy;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.framework.recipes.cache.NodeCache;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.data.Stat;
import org.junit.Test;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Package:com.ray.educatesystem.stream
 * *Author:ray
 * *version:...
 * *Created in 2019/10/30  19:57
 **/
public class StreamDemo {

	//连接地址
	private static final String zookeeperAddr = "127.0.0.1:2181";
	//连接超时时间
	private static final int SESSION_TIMEOUT = 5000;


	@Test
	public void curatorCRUD() throws Exception {
		//重试策略    重试时间1s  重试10次
		RetryPolicy policy=new ExponentialBackoffRetry(1000,10);      //Exponential 指数的?   创建重连策略

		//创建连接,开启连接
		CuratorFramework curatorFramework= CuratorFrameworkFactory.builder().connectString(zookeeperAddr)
				.sessionTimeoutMs(SESSION_TIMEOUT).retryPolicy(policy).build();
		curatorFramework.start();

		ExecutorService executor= Executors.newCachedThreadPool();

		//创建节点
		/**创建节点，creatingParentsIfNeeded()方法的意思是如果父节点不存在，则在创建节点的同时创建父节点；
		 * withMode()方法指定创建的节点类型，跟原生的Zookeeper API一样，不设置默认为PERSISTENT类型。
		 * */
		curatorFramework.create().creatingParentsIfNeeded().withMode(CreateMode.PERSISTENT)
				.inBackground((framework,event)->{
					System.out.println("Code"+event.getResultCode());
					System.out.println("Type"+event.getType());
					System.out.println("path"+event.getPath());
				},executor).forPath("/super/C1","c1内容".getBytes());
		Thread.sleep(5000);


		//获取节点的数据
		byte[] bytes = curatorFramework.getData().forPath("/super/C1");
		String str=new String(bytes);
		System.out.println(str);
		//检查节点的数据是否存在
		Stat stat = curatorFramework.checkExists().forPath("/super/C1");
		System.out.println(stat);
		//更新节点的数据
		curatorFramework.setData().forPath("/super/C1","新的c1内容".getBytes());
		String str1=new String(curatorFramework.getData().forPath("/super/C1"));
		System.out.println(str1);

		//获取子节点
		List<String> strings = curatorFramework.getChildren().forPath("/super");
		for (String string : strings) {
			System.out.println(string);
		}
		//删除子节点
		//放心的删除节点，deletingChildrenIfNeeded()方法表示如果存在子节点的话，同时删除子节点
		curatorFramework.delete().guaranteed().deletingChildrenIfNeeded().forPath("/super");
		curatorFramework.close();

		//PS：create创建节点方法可选的链式项：creatingParentsIfNeeded（是否同时创建父节点）、withMode（创建的节点类型）、forPath（创建的节点路径）、withACL（安全项）
		//delete删除节点方法可选的链式项：deletingChildrenIfNeeded（是否同时删除子节点）、guaranteed（安全删除）、withVersion（版本检查）、forPath（删除的节点路径）
		//inBackground绑定异步回调方法。比如在创建节点时绑定一个回调方法，该回调方法可以输出服务器的状态码以及服务器的事件类型等信息，还可以加入一个线程池进行优化操作。
	}




	@Test
	public void testListener() throws Exception {
		//重试策略    重试时间1s  重试10次
		RetryPolicy policy=new ExponentialBackoffRetry(1000,10);      //Exponential 指数的?   创建重连策略

		//创建连接,开启连接
		CuratorFramework curatorFramework= CuratorFrameworkFactory.builder().connectString(zookeeperAddr)
				.sessionTimeoutMs(SESSION_TIMEOUT).retryPolicy(policy).build();
		curatorFramework.start();

		//最后一个参数表示是否会进行压缩
		NodeCache cache=new NodeCache(curatorFramework,"/super",false);
		cache.start(true);
		//监听节点的创建和修改
		cache.getListenable().addListener(()->{
			System.out.println("路径：" + cache.getCurrentData().getPath());
			System.out.println("数据：" + new String(cache.getCurrentData().getData()));
			System.out.println("状态：" + cache.getCurrentData().getStat());
		});

		curatorFramework.create().forPath("/super", "1234".getBytes());
		Thread.sleep(1000);
		curatorFramework.setData().forPath("/super", "5678".getBytes());
		Thread.sleep(1000);
		curatorFramework.delete().forPath("/super");
		Thread.sleep(5000);
		curatorFramework.close();
	}

}
