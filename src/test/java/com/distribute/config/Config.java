package com.distribute.config;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.framework.CuratorTempFramework;
import org.apache.curator.framework.recipes.cache.PathChildrenCache;
import org.apache.curator.framework.recipes.cache.PathChildrenCacheEvent;
import org.apache.curator.framework.recipes.cache.PathChildrenCacheListener;
import org.apache.curator.retry.RetryNTimes;
import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.data.Stat;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Package:com.distribute.config
 * *Author:ray
 * *version:...
 * *Created in 2020/3/13  12:48
 **/
public class Config {

	private String connectUrl = "localhost:2181";

	private ConcurrentHashMap<String, String> cache = new ConcurrentHashMap<>();

	private CuratorFramework client;

	private static String CONFIG_PREFIX = "/CONFIG";

	public Config() {
		this.client = CuratorFrameworkFactory.newClient(connectUrl, new RetryNTimes(3, 1000));
		client.start();
	}

	//初始化一个value
	public void init() {
		try {
			List<String> strings = client.getChildren().forPath(CONFIG_PREFIX);
			if (CollectionUtils.isNotEmpty(strings)){
				strings.forEach(str->{
					try {
						String value = new String(client.getData().forPath(CONFIG_PREFIX + "/" + str));
						cache.put(str,value);
					} catch (Exception e) {
						e.printStackTrace();
					}
				});
			}
			//绑定监听器来处理数据,监听子节点的增加
			PathChildrenCache watcher =new PathChildrenCache(client,CONFIG_PREFIX,true);  //true的时候返回变化的节点值

			//对节点的数据进行监听处理
			watcher.getListenable().addListener(new PathChildrenCacheListener() {
				@Override
				public void childEvent(CuratorFramework curatorFramework, PathChildrenCacheEvent event) throws Exception {
					//判断事件的类型
					String path = event.getData().getPath();//返回的是全路径
					if (path.startsWith(CONFIG_PREFIX)) {
						String key = path.replace(CONFIG_PREFIX + "/", "");
						if (PathChildrenCacheEvent.Type.CHILD_ADDED.equals(event.getType())
						||PathChildrenCacheEvent.Type.CHILD_UPDATED.equals(event.getType())) {
							cache.put(key,new String(event.getData().getData()));
						}else{
							cache.remove(key);
						}
					}
				}
			});
			watcher.start();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


	//新增和更新
	public void save(String key, String value) {
		//zk
		String configUrl = CONFIG_PREFIX + "/" + key;
		try {
			Stat stat = client.checkExists().forPath(configUrl);
			if (stat == null) {
				//创建的是一个持久的节点,支持递归创建节点
				client.create().creatingParentContainersIfNeeded().withMode(CreateMode.PERSISTENT).forPath(configUrl,value.getBytes());
			}else{
				client.setData().forPath(configUrl,value.getBytes());
			}
			//放一个数据到缓存
			cache.put(key,value);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public String get(String name) {
		//获取参数的时候
		return cache.get(name);
	}

	public void close(){

	}

}
