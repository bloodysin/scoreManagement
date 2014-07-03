package com.bloodysin.scoremanagement.impl;

import com.bloodysin.scoremanagement.dao.*;
import com.bloodysin.scoremanagement.model.*;
import com.bloodysin.scoremanagement.util.BasicSqlSupport;

public class ScoreDAOImpl extends BasicSqlSupport implements ScoreDAO{
	@Override
	public void updateScore(Score score) {
		this.session.update("com.bloodysin.scoremanagement.mapper.ScoreMapper.updateScore", score);
	}
	
	@Override
	public void insertScore(Score score) {
		this.session.insert("com.bloodysin.scoremanagement.mapper.ScoreMapper.insertScore", score);
	}

}
