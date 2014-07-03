package com.bloodysin.scoremanagement.impl;

import java.util.List;

import com.bloodysin.scoremanagement.dao.*;
import com.bloodysin.scoremanagement.model.*;
import com.bloodysin.scoremanagement.util.BasicSqlSupport;

public class StudentScoreDAOImpl extends BasicSqlSupport implements StudentScoreDAO {
	@Override
	public List<StudentScore> getStudentScoreList(int courseId) {
		return this.session.selectList("com.bloodysin.scoremanagement.mapper.StudentScoreMapper.getStudentScore", courseId);
	}
}
