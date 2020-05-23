package com.concurrency.javalock;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * Package:com.concurrency.javalock
 * *Author:ray
 * *version:...
 * *Created in 2020/1/23  3:05
 **/
public class RWLockCache<K,V> {

	final Map<K,V> map=new HashMap<>();

	final ReadWriteLock readWriteLock= new ReentrantReadWriteLock();

	final Lock writeLock = readWriteLock.writeLock();
	final Lock readLock = readWriteLock.readLock();

	V get(K key){
		V v=null;
		//读缓存
		readLock.lock();
		try{
			v=map.get(key);
		}finally{
			readLock.unlock();
		}

		if (v != null) {
			return v;
		}
		//如果缓存中不存在数据
		writeLock.lock();
		try {
			v = map.get(key);
			if (v == null) {
				//v=   查询数据库获取数据
				map.put(key,v);
			}
		} finally {
			writeLock.unlock();
		}
		return v;
	};
}
