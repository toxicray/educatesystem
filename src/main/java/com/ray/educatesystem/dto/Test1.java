package com.ray.educatesystem.dto;

import javax.persistence.*;
import java.util.Date;

/**
 * Package:com.ray.educatesystem.dto
 * *Author:ray
 * *version:...
 * *Created in 2019/7/13  11:49
 **/
@Table(name = "test1")
public class Test1 {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	/**
	 * 名称
	 */
	@Column(name = "name")
	private String name;

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	@Column(name = "count")
	private Integer count;

	@Column(name = "create_time")
	private Date createTime;

	@Column(name = "sequence")
	private Integer sequence;

	@Column(name = "test")
	private Integer test;


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

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Integer getSequence() {
		return sequence;
	}

	public void setSequence(Integer sequence) {
		this.sequence = sequence;
	}

	public Integer getTest() {
		return test;
	}

	public void setTest(Integer test) {
		this.test = test;
	}
}
