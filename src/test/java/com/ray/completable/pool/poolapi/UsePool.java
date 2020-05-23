package com.ray.completable.pool.poolapi;

import com.ray.completable.Demo;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Package:com.ray.completable.pool.poolapi
 * *Author:ray
 * *version:...
 * *Created in 2020/1/28  22:18
 **/
public class UsePool {
	public static void main(String[] args) {
		//创建线程池
		ThreadPoolExecutor pool = new ThreadPoolExecutor(5,
				10,
				60,
				TimeUnit.SECONDS,
				new LinkedBlockingQueue<>(10),
				r -> new Thread(r, "ray" + r.hashCode()),
				(r, q) -> {
					System.out.println("拒绝策略");
				});

		Demo demo=new Demo();
		pool.submit(()-> {
			demo.setName("ray");
		});

		pool.submit(()-> {
			demo.setNickName("tyrion");
		});
		System.out.println(demo.toString());
	}

	static class Demo {
		private String name;
		private String nickName;

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getNickName() {
			return nickName;
		}

		public void setNickName(String nickName) {
			this.nickName = nickName;
		}

		@Override
		public String toString() {
			return "Demo{" +
					"name='" + name + '\'' +
					", nickName='" + nickName + '\'' +
					'}';
		}
	}
}
