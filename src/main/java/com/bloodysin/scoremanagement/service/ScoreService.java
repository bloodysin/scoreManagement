package com.bloodysin.scoremanagement.service;

import com.bloodysin.scoremanagement.model.*;
import com.bloodysin.scoremanagement.dao.*;

public class ScoreService {
	private ScoreDAO scoreDAO = null;
	public ScoreDAO getScoreDAO() {
		return scoreDAO;
	}
	
	public void setScoreDAO(ScoreDAO scoreDAO) {
		this.scoreDAO = scoreDAO;
	}
	
	public void changeScore(int value, int courseId, int userId) {
		Score score = new Score();
		score.setValue(value);
		score.setCourseId(courseId);
		score.setUserId(userId);
		scoreDAO.updateScore(score);
	}
	
	public void addScore(int value, int courseId, int userId) {
		Score score = new Score();
		score.setCourseId(courseId);
		score.setUserId(userId);
		score.setValue(value);
		scoreDAO.insertScore(score);
	}
}
