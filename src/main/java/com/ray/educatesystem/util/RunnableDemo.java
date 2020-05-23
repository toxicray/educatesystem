package com.ray.educatesystem.util;

import com.ray.educatesystem.bo.StudentBO;
import com.ray.educatesystem.dto.StudentInfo;
import com.ray.educatesystem.dto.Teacher;
import com.ray.educatesystem.mapper.StudentInfoMapper;
import com.ray.educatesystem.mapper.TeacherMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Package:com.ray.educatesystem.util
 * *Author:ray
 * *version:...
 * *Created in 2019/11/24  12:08
 **/
public class RunnableDemo implements Runnable {


	private StudentInfoMapper studentInfoMapper;


	private TeacherMapper teacherMapper;

	private StudentBO studentBO;

	public RunnableDemo(StudentBO studentBO,StudentInfoMapper mapper1,TeacherMapper mapper2) {
		this.studentBO = studentBO;
		this.studentInfoMapper=mapper1;
		this.teacherMapper=mapper2;
	}

	public RunnableDemo() {
	}

	@Override
	public void run() {
		StudentInfo studentInfo = studentInfoMapper.selectByPrimaryKey(studentBO.getId());
		BeanUtils.copyProperties(studentInfo,studentBO );
		Teacher teacher = teacherMapper.selectByPrimaryKey(studentBO.getTeacherId());
		BeanUtils.copyProperties(teacher,studentBO );
	}
}
