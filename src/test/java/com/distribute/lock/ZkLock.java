package com.distribute.lock;

import org.apache.zookeeper.*;

import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/**
 * Package:com.distribute.lock
 * *Author:ray
 * *version:...
 * *Created in 2020/3/12  22:55
 **/
public class ZkLock {


	private static ThreadLocal<ZooKeeper> zooKeeper =new ThreadLocal<>();

	private static String LOCK_NAME = "/LOCK";

	private ThreadLocal<String> CURRENT_NAME =new ThreadLocal<>();

	private void init(){
		if (zooKeeper.get() == null) {
			try {
				zooKeeper .set(new ZooKeeper("localhost:2181", 300, new Watcher() {
					@Override
					public void process(WatchedEvent watchedEvent) {
						//
					}
				}));
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public boolean lock(){
		init();
		if (tryLock()) {
			System.out.println(Thread.currentThread().getName()+"获取锁成功");
			return tryLock();
		}
		return false;
	}

	//服务端会根据会话超时的时间来处理断掉的临时节点
	public void unlock(){
		try {
			zooKeeper.get().delete(CURRENT_NAME.get(),-1);  //传入-1的话,说明是忽略版本号
			CURRENT_NAME.remove();
			zooKeeper.get().close();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (KeeperException e) {
			e.printStackTrace();
		}
	}



	//这个是一个公平锁,有序的处理
	public boolean tryLock() {
		String nodeName = LOCK_NAME+"/zk_";
		try {
			//返回的是全路径  /LOCK/zk_
			CURRENT_NAME.set(zooKeeper.get().create(nodeName, new byte[0], ZooDefs.Ids.CREATOR_ALL_ACL, CreateMode.EPHEMERAL_SEQUENTIAL));

			List<String> list = zooKeeper.get().getChildren(LOCK_NAME, false);
			Collections.sort(list);

			String minNodeName = list.get(0);
			if (CURRENT_NAME.equals(LOCK_NAME+"/"+minNodeName)){
				return true;
			}else{
				//监听当前节点的前一个节点
				int i = list.indexOf(CURRENT_NAME.get().substring(CURRENT_NAME.get().lastIndexOf("/") + 1));
				String preNodeName = list.get(i - 1);
				//该部分的代码是非阻塞
				CountDownLatch latch =new CountDownLatch(1);
				zooKeeper.get().exists(LOCK_NAME+"/"+preNodeName, new Watcher() {
					@Override
					public void process(WatchedEvent event) {
						if (Event.EventType.NodeDeleted.equals(event.getType())){
							//如果当前的节点删除,说明之前的锁已经被释放了
							System.out.println(Thread.currentThread().getName()+"被唤醒了" );
							latch.countDown();   //类似于挂号之后被等待叫号
						}
					}
				});
				System.out.println(Thread.currentThread().getName()+"被阻塞了" );
				latch.await();
				return true;
			}
		} catch (KeeperException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return false;
	}
}
