package com.ray.educatesystem.service.pattern.strategy.method;

import com.ray.educatesystem.service.pattern.strategy.CheckMethod;
import com.ray.educatesystem.service.pattern.strategy.CheckResultVO;

/**
 * Package:com.ray.educatesystem.service.pattern.strategy.method
 * *Author:ray
 * *version:...
 * *Created in 2020/2/16  21:09
 **/
public class DefaultCheck implements CheckMethod {
	@Override
	public CheckResultVO execute(String str) {
		return new CheckResultVO("默认不校验: 不合格",0);
	}
}
