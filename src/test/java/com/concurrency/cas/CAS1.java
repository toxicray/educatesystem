package com.concurrency.cas;

import java.util.*;
import java.util.concurrent.CountDownLatch;

/**
 * Package:com.concurrency.cas
 * *Author:ray
 * *version:...
 * *Created in 2020/3/16  22:10
 **/
public class CAS1 {

	public CAS1() {
	}

	private static volatile int m=0;

	public  static void inCrease(){
		m++;
	}

	public static void main(String[] args) throws InterruptedException {
		CountDownLatch lock =new CountDownLatch(20);
		for (int i = 0; i < 20; i++) {
			new Thread(()->{
				CAS1.inCrease();
				lock.countDown();
			}).start();
		}
		lock.await();
		System.out.println(m);

		Map<Integer,Integer> map = new HashMap<>();
		TreeMap<Integer,Integer> map1 = new TreeMap<>((a,b)->b-a);

	}

	public boolean isRectangleOverlap(int[] rec1, int[] rec2) {
		int radio1 = rec1[0]*rec1[0] + rec1[1]*rec1[1];
		int radio2 = rec1[2]*rec1[2] + rec1[3]*rec1[3];
		int radio3 = rec2[0]*rec2[0] + rec2[1]*rec2[1];
		int radio4 = rec2[2]*rec1[2] + rec2[3]*rec2[3];
		return (radio1<radio4 && radio2>radio3)||(radio1>radio4 && radio2<radio3);
	}

	public void testPriority(){
		PriorityQueue<Integer> queue = new PriorityQueue<>();
		queue.peek();
		LinkedList<Integer> list = new LinkedList<Integer>();
		Stack<Integer> stack = new Stack<>();
		list.pollLast();
	}


}
