package com.ray.educatesystem;

/**
 * Package:com.ray.educatesystem
 * *Author:ray
 * *version:...
 * *Created in 2020/1/10  22:51
 **/
public class CloneDemo {
	public static void main(String[] args) throws CloneNotSupportedException {
		Student student=new Student("ray", 18);
		//Object[] arr={student,3};
		//
		//Object[] newArr = arr.clone();
		//Student s = (Student)newArr[0];
		//s.setAge(19);
		//System.out.println(student.getAge());

		Object clone = student.clone();
		Student ns=(Student) clone;
		System.out.println(ns.getAge()+ns.getName());
		System.out.println(ns.toString());
		System.out.println(student.toString());
	}
	static class Clone{
		Object[] arr;
	}
	static class Student extends BaseClone{
		private String name;
		private Integer age;

		public Student(String name, Integer age) {
			this.name = name;
			this.age = age;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public Integer getAge() {
			return age;
		}

		public void setAge(Integer age) {
			this.age = age;
		}
	}
	static class BaseClone implements Cloneable{
		@Override
		public Object clone() throws CloneNotSupportedException {
			return super.clone();
		}
	}
}
