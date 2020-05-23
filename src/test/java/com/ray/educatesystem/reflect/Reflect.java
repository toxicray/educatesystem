package com.ray.educatesystem.reflect;

import com.ray.completable.Demo;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.stream.Stream;

/**
 * Package:com.ray.educatesystem.reflect
 * *Author:ray
 * *version:...
 * *Created in 2019/12/23  20:47
 **/
public class Reflect {
	public static void main(String[] args) throws IllegalAccessException, InstantiationException {
		Demo demo = new Demo(1,3l,"21");
		//Method[] declaredMethods = demo.getClass().getDeclaredMethods();
		//Stream.of(declaredMethods).forEach((a)->{
		//	//System.out.println(a.getName());
		//	if (a.getName().equals("setA")){
		//		try {
		//			a.invoke(demo,3);
		//		} catch (IllegalAccessException e) {
		//			e.printStackTrace();
		//		} catch (InvocationTargetException e) {
		//			e.printStackTrace();
		//		}
		//	}
		//});
		//System.out.println(demo.getA());
		Field[] declaredFields = demo.getClass().getDeclaredFields();
		Stream.of(declaredFields).forEach((field)->{
			field.setAccessible(true);
			//try {
			//	System.out.println(field.get(demo).toString());
			//} catch (IllegalAccessException e) {
			//	e.printStackTrace();
			//}
			if (field.getType().getName().endsWith("Integer")){
				try {
					int o = (int)field.get(demo);
					demo.setA(o*10);
				} catch (IllegalAccessException e) {
					e.printStackTrace();
				}
			}
		});
		System.out.println(demo.getA());
	}

	static class Demo{
		private Integer a;
		private Long b;
		private String str;

		public Demo(Integer a, Long b, String str) {
			this.a = a;
			this.b = b;
			this.str = str;
		}

		public Integer getA() {
			return a;
		}

		public void setA(Integer a) {
			this.a = a;
		}

		public Long getB() {
			return b;
		}

		public void setB(Long b) {
			this.b = b;
		}

		public String getStr() {
			return str;
		}

		public void setStr(String str) {
			this.str = str;
		}
	}
}
