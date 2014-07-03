package com.bloodysin.scoremanagement.impl;

import java.util.List;

import com.bloodysin.scoremanagement.dao.*;
import com.bloodysin.scoremanagement.model.*;
import com.bloodysin.scoremanagement.util.BasicSqlSupport;

public class ScoreTableDAOImpl extends BasicSqlSupport implements ScoreTableDAO {
	@Override
	public List<ScoreTable> getScoreTable(int userId) {
		return this.session.selectList("com.bloodysin.scoremanagement.mapper.ScoreTableMapper.getScoreTable", userId);
	}
}
