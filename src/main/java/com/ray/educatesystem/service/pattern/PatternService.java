package com.ray.educatesystem.service.pattern;

import com.ray.educatesystem.service.pattern.strategy.CheckResultVO;
import com.ray.educatesystem.service.pattern.strategy.CheckShelfLifeActivity;
import com.ray.educatesystem.service.pattern.strategy.method.CheckMethodFactory;
import org.springframework.stereotype.Service;

/**
 * Package:com.ray.educatesystem.service
 * *Author:ray
 * *version:...
 * *Created in 2020/2/16  20:47
 **/
@Service
public class PatternService {

	public CheckResultVO testStrategyMethod(String str) {
		CheckShelfLifeActivity check = new CheckShelfLifeActivity(CheckMethodFactory.getCheckMethod(str));
		return check.executeCheck("123");
	}
}
