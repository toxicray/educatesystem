package com.ray.educatesystem.service.pattern.strategy;

/**
 * Package:com.ray.educatesystem.service.pattern
 * *Author:ray
 * *version:...
 * *Created in 2020/2/16  20:57
 **/
public class CheckResultVO {


	private String checkWay;

	private Integer checkCode;

	public CheckResultVO() {

	}

	public CheckResultVO(String checkWay, Integer checkCode) {
		this.checkWay = checkWay;
		this.checkCode = checkCode;
	}

	public String getCheckWay() {
		return checkWay;
	}

	public void setCheckWay(String checkWay) {
		this.checkWay = checkWay;
	}

	public Integer getCheckCode() {
		return checkCode;
	}

	public void setCheckCode(Integer checkCode) {
		this.checkCode = checkCode;
	}
}
