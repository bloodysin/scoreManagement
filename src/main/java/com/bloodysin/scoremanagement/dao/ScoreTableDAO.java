package com.bloodysin.scoremanagement.dao;

import java.util.List;

import com.bloodysin.scoremanagement.model.*;

public interface ScoreTableDAO {
	public List<ScoreTable> getScoreTable(int userId);
}
