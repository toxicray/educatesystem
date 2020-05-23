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
 * *Created in 2020/1/23  2:40
 **/
public class ReadWriteLockCache<K,V> {

	final Map<K,V> map=new HashMap<>();

	//分为公平锁和非公平锁,默认为非公平锁(如果是非公平锁可能会导致线程饥饿,获取不到cpu资源)
	final ReadWriteLock readWriteLock=new ReentrantReadWriteLock();

	//读写锁的配对使用,实现原理,TBL!
	final Lock writeLock=readWriteLock.writeLock();  //获取写锁
	final Lock readLock=readWriteLock.readLock();   //获取读锁

	V get(K key){
		readLock.lock();
		try{
			return map.get(key);
		}finally {
			readLock.unlock();
		}
	}

	void put(K key,V value){
		writeLock.lock();
		try {
		    map.put(key, value);
		} finally {
			writeLock.unlock();
		}
	}
}
