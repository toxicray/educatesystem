package com.ray.educatesystem.controller;

import com.ray.educatesystem.service.pattern.PatternService;
import com.ray.educatesystem.service.pattern.strategy.CheckResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * Package:com.ray.educatesystem.controller
 * *Author:ray
 * *version:...
 * *Created in 2020/2/16  20:41
 **/
@RestController
public class TestPatternController {

	@Autowired
	private PatternService patternService;

	@GetMapping("pattern/{str}")
	public CheckResultVO testTransactionAnother(@PathVariable String str){
		return patternService.testStrategyMethod(str);
	}
}
