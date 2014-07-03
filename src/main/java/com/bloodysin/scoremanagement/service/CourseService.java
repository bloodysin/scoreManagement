package com.bloodysin.scoremanagement.service;

import java.util.List;

import com.bloodysin.scoremanagement.model.*;
import com.bloodysin.scoremanagement.dao.*;

public class CourseService {
	private CourseDAO courseDAO = null;
	
	public CourseDAO getCourseDAO() {
		return courseDAO;
	}
	
	public void setCourseDAO(CourseDAO courseDAO) {
		this.courseDAO = courseDAO;
	}
	
	public void addCourse(String courseName, int userId) {
		Course course = new Course();
		course.setCourseName(courseName);
		course.setUserId(userId);
		courseDAO.insertCourse(course);
	}
	
	public List<Course> getCourseList(int userId) {
		return courseDAO.getCourseList(userId);
	}

}
