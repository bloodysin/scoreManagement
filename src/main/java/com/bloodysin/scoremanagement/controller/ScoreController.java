package com.bloodysin.scoremanagement.controller;

import javax.annotation.Resource; 

import org.springframework.stereotype.Controller; 
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.bloodysin.scoremanagement.model.*;
import com.bloodysin.scoremanagement.service.*;

@Controller
public class ScoreController {

	@Resource(name="ScoreService")
	private ScoreService scoreService = null;
	public void setScoreService(ScoreService scoreService) {
		this.scoreService = scoreService;
	}
	
	@RequestMapping(value="/change_score.do", method=RequestMethod.GET)
	public String changeScore(@RequestParam(value="user_id") int teacherId,
							  @RequestParam(value="c_id") int courseId,
							  @RequestParam(value="s_id") int studentId,
							  Model model) {
		Score score = new Score();
		model.addAttribute("teacherId", teacherId);
		model.addAttribute("courseId", courseId);
		model.addAttribute("studentId", studentId);
		model.addAttribute("score", score);
		return "change_score";
	}
	
	@RequestMapping(value="/change_score.do", method=RequestMethod.POST)
	public String updateScore(@ModelAttribute("score") Score score,
							  @RequestParam(value="user_id") int teacherId,
							  @RequestParam(value="c_id") int courseId,
							  @RequestParam(value="s_id") int studentId,
							  Model model) {
		model.addAttribute("score", score);
		model.addAttribute("teacherId", teacherId);
		model.addAttribute("courseId", courseId);
		model.addAttribute("studentId", studentId);
		scoreService.changeScore(score.getValue(), courseId, studentId);
		return "redirect:score.do?user_id=" + teacherId + "&c_id=" + courseId;
	}
}
