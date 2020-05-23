package com.ray.educatesystem.service.pattern.strategy;

/**
 * Package:com.ray.educatesystem.service.pattern
 * *Author:ray
 * *version:...
 * *Created in 2020/2/16  20:53
 **/
public class CheckShelfLifeActivity {

	private CheckMethod method;

	public CheckShelfLifeActivity(CheckMethod method) {
		this.method = method;
	}
	public CheckResultVO executeCheck(String str){
		return method.execute("校验入参");
	}

}
