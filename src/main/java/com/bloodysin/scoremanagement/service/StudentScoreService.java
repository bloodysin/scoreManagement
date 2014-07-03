package com.bloodysin.scoremanagement.service;

import java.util.List;

import com.bloodysin.scoremanagement.model.*;
import com.bloodysin.scoremanagement.dao.*;

public class StudentScoreService {
	private StudentScoreDAO studentScoreDAO = null;
	
	public StudentScoreDAO getStudentScoreDAO() {
		return studentScoreDAO;
	}
	
	public void setStudentScoreDAO(StudentScoreDAO studentScoreDAO) {
		this.studentScoreDAO = studentScoreDAO;
	}
	
	public List<StudentScore> getScoreList(int courseId) {
		return studentScoreDAO.getStudentScoreList(courseId);
	}
}
