package com.ray.educatesystem.bo;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Package:com.ray.educatesystem.bo
 * *Author:ray
 * *version:...
 * *Created in 2019/11/24  11:54
 **/
public class StudentBO {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "name")
	private String name;

	@Column(name = "student_code")
	private Long studentCode;

	/**
	 * @Description false 女 true 男
	 *
	 **/
	@Column(name = "gender")
	private Boolean gender;

	@Column(name = "name")
	private String address;


	@Column(name = "qq_number")
	private Long qqNumber;

	@Column(name = "phone")
	private Long phone;

	@Column(name = "teacher_id")
	private Integer teacherId;

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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getStudentCode() {
		return studentCode;
	}

	public void setStudentCode(Long studentCode) {
		this.studentCode = studentCode;
	}

	public Boolean getGender() {
		return gender;
	}

	public void setGender(Boolean gender) {
		this.gender = gender;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Long getQqNumber() {
		return qqNumber;
	}

	public void setQqNumber(Long qqNumber) {
		this.qqNumber = qqNumber;
	}

	public Long getPhone() {
		return phone;
	}

	public void setPhone(Long phone) {
		this.phone = phone;
	}

	public Integer getTeacherId() {
		return teacherId;
	}

	public void setTeacherId(Integer teacherId) {
		this.teacherId = teacherId;
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
