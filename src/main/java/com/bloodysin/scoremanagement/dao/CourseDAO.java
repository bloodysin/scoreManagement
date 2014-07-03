package com.bloodysin.scoremanagement.dao;

import java.util.List;

import com.bloodysin.scoremanagement.model.*;

public interface CourseDAO {
	public void insertCourse(Course course);
	
	public List<Course> getCourseList(int userId);
}
