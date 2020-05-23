package com.ray.educatesystem.dto;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Package:com.ray.educatesystem.dto
 * *Author:ray
 * *version:...
 * *Created in 2019/11/24  11:44
 **/
public class Teacher {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "teacher_name")
	private String teacherName;

	@Column(name = "teacher_course")
	private String teacherCourse;

	@Column(name = "teacher_gender")
	private Boolean teacherGender;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTeacherName() {
		return teacherName;
	}

	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
	}

	public String getTeacherCourse() {
		return teacherCourse;
	}

	public void setTeacherCourse(String teacherCourse) {
		this.teacherCourse = teacherCourse;
	}

	public Boolean getTeacherGender() {
		return teacherGender;
	}

	public void setTeacherGender(Boolean teacherGender) {
		this.teacherGender = teacherGender;
	}
}
