package com.ray.educatesystem.dto;

import javax.persistence.*;
import java.util.Date;

/**
 * Package:com.ray.educatesystem.dto
 * *Author:ray
 * *version:...
 * *Created in 2019/7/20  23:40
 **/
@Table(name = "test2")
public class Test2 {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	/**
	 * 名称
	 */
	@Column(name = "name")
	private String name;


	@Column(name = "count")
	private Integer count;

	@Column(name = "create_time")
	private Date createTime;


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

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}


	@Override
	public String toString() {
		return "Test{" +
				"id=" + id +
				", name='" + name + '\'' +
				", count=" + count +
				", createTime=" + createTime +
				'}';
	}
}
