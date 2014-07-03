package com.bloodysin.scoremanagement.controller;

import java.util.List;

import javax.annotation.Resource; 

import org.springframework.stereotype.Controller; 
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.bloodysin.scoremanagement.model.*;
import com.bloodysin.scoremanagement.service.*;

@Controller
public class ScoreTableController {
	
	@Resource(name="UserService")
	private UserService userService = null;
	@Resource(name="ScoreTableService")
	private ScoreTableService scoreTableService = null;
	public void setScoreTableService(ScoreTableService scoreTableService) {
		this.scoreTableService = scoreTableService;
	}
	
	@RequestMapping(value="/student_dashboard.do", method=RequestMethod.GET)
	public String getList(@RequestParam(value="user_id") int userId, Model model) {
		List<ScoreTable> list = scoreTableService.getScoreList(userId);
		model.addAttribute("list", list);
		String userName = userService.getUserById(userId).getUserName();
		model.addAttribute("name", userName);
		return "student_dashboard";
	}

}
