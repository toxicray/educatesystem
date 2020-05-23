package com.ray.educatesystem.mapper;

import com.ray.educatesystem.dto.Test1;
import com.ray.educatesystem.util.BaseMapper;
import org.springframework.stereotype.Repository;

/**
 * Package:com.ray.educatesystem.mapper
 * *Author:ray
 * *version:...
 * *Created in 2019/7/13  11:53
 **/
@Repository
public interface Test1Mapper extends BaseMapper<Test1> {

	int updateTest1(Test1 test);


}
