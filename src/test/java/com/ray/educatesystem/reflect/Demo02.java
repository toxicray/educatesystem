package com.ray.educatesystem.reflect;

/**
 * Package:com.ray.educatesystem.reflect
 * *Author:ray
 * *version:...
 * *Created in 2019/12/23  22:20
 **/
public class Demo02 {
	public static void main(String[] args) throws IllegalAccessException, InstantiationException {
		Demo demo = new Demo(1,3l,"21");
		Demo demo1 = demo.getClass().newInstance();
		System.out.println(demo1);
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
