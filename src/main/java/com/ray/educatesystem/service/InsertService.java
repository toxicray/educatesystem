package com.ray.educatesystem.service;

import com.ray.educatesystem.dto.Teacher;
import com.ray.educatesystem.mapper.TeacherMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Package:com.ray.educatesystem.service
 * *Author:ray
 * *version:...
 * *Created in 2019/12/11  23:15
 **/
@Service
@Transactional
public class InsertService {

	@Autowired
	private TeacherMapper teacherMapper;

	public int insertList(List<Teacher> list){
		return teacherMapper.insertList(list);
	}


}
