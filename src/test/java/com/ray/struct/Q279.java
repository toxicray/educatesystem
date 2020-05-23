package com.ray.struct;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Package:com.ray.struct
 * *Author:ray
 * *version:...
 * *Created in 2019/12/16  23:03
 **/
public class Q279 {

	private static class Node {
		int val;
		int step;

		public Node(int val, int step) {
			this.val = val;
			this.step = step;
		}
	}

	public static void main(String[] args) {
		System.out.println(squars(12));

	}
	public static int squars(int n){
		Queue<Node> queue=new LinkedList<>();
		queue.add(new Node(n,1));
		boolean record[] =new boolean[n];
		while (!queue.isEmpty()){
			int val = queue.peek().val;
			int step = queue.peek().step;
			queue.remove();

			for (int i=1;;i++){
				int nextVal=val-i*i;
				if (nextVal<0){
				    break;
				}
				if (nextVal==0){
				    return step;
				}
				if (!record[nextVal]){
				    queue.add(new Node(nextVal,step+1));
				    record[nextVal]=true;
				}
			}
		}
		return -1;
	}
}
