package com.ray.educatesystem.util;

import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

/**
 * Package:com.ray.educatesystem.util
 * *Author:ray
 * *version:...
 * *Created in 2019/7/13  11:50
 **/
/**
 *@Description 用作通用的父级接口
		* @Param
		* @return
		**/

public interface BaseMapper<T> extends Mapper<T>,MySqlMapper<T> {


}
