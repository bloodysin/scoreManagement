package com.bloodysin.scoremanagement.service;

import java.util.List;

import com.bloodysin.scoremanagement.model.*;
import com.bloodysin.scoremanagement.dao.*;

public class ScoreTableService {
	private ScoreTableDAO scoreTableDAO = null;
	
	public ScoreTableDAO getScoreTableDAO() {
		return scoreTableDAO;
	}
	
	public void setScoreTableDAO(ScoreTableDAO scoreTableDAO) {
		this.scoreTableDAO = scoreTableDAO;
	}
	
	public List<ScoreTable> getScoreList(int userId) {
		return scoreTableDAO.getScoreTable(userId);
	}
}
