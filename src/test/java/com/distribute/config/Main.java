package com.distribute.config;

/**
 * Package:com.distribute.config
 * *Author:ray
 * *version:...
 * *Created in 2020/3/13  20:11
 **/
public class Main {
	public static void main(String[] args) {
		Config config=new Config();
		config.save("timeout", "100");
		for (int i = 0; i < 100; i++) {
			System.out.println(config.get("timeout"));
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
