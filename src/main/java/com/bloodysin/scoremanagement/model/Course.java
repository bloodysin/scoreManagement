package com.bloodysin.scoremanagement.model;

public class Course {
	private int courseId;
	private String courseName;
	private int userId;
	
	public int getCourseId() {
		return courseId;
	}
	
	public String getCourseName() {
		return courseName;
	}
	
	public int getTeacherId() {
		return userId;
	}
	
	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}
	
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	
	public void setUserId(int userId) {
		this.userId = userId;
	}
}
