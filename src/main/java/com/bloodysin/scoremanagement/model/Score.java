package com.bloodysin.scoremanagement.model;

public class Score {
	private int userId;
	private int courseId;
	private int value;
	
	public int getStudentId() {
		return userId;
	}
	
	public int getCourseId() {
		return courseId;
	}
	
	public int getValue() {
		return value;
	}
	
	public void setUserId(int userId) {
		this.userId = userId;
	}
	
	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}
	
	public void setValue(int value) {
		this.value = value;
	}
}
