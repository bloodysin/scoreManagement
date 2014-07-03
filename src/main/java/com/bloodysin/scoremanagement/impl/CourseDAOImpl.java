package com.bloodysin.scoremanagement.impl;

import java.util.List;

import com.bloodysin.scoremanagement.dao.*;
import com.bloodysin.scoremanagement.model.*;
import com.bloodysin.scoremanagement.util.BasicSqlSupport;

public class CourseDAOImpl extends BasicSqlSupport implements CourseDAO{
	@Override
	public void insertCourse(Course course) {
		this.session.insert("com.bloodysin.scoremanagement.mapper.CourseMapper.insertCourse", course);
	}
	
	@Override
	public List<Course> getCourseList(int userId) {
		return this.session.selectList("com.bloodysin.scoremanagement.mapper.CourseMapper.getCourseList", userId);
	}
}
