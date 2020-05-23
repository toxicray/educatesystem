package com.ray.educatesystem.dto;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Package:com.ray.educatesystem.dto
 * *Author:ray
 * *version:...
 * *Created in 2019/11/24  11:12
 **/
public class StudentInfo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	/**
	 * 名称
	 */
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
}
