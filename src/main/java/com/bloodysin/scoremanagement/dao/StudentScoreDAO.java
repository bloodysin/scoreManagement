package com.bloodysin.scoremanagement.dao;

import java.util.List;

import com.bloodysin.scoremanagement.model.*;

public interface StudentScoreDAO {
	public List<StudentScore> getStudentScoreList(int courseId);
}
