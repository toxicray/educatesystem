package com.ray.educatesystem.service.pattern.strategy.method;

import com.ray.educatesystem.service.pattern.strategy.CheckMethod;
import com.ray.educatesystem.service.pattern.strategy.CheckResultVO;

/**
 * Package:com.ray.educatesystem.service.pattern.strategy.method
 * *Author:ray
 * *version:...
 * *Created in 2020/2/16  21:01
 **/
public class NoCheck implements CheckMethod {
	@Override
	public CheckResultVO execute(String str) {
		return new CheckResultVO("不用校验: 合格",1);
	}
}
