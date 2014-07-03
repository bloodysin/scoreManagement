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
public class StudentScoreController {
	
	@Resource(name="StudentScoreService")
	private StudentScoreService studentScoreService = null;
	public void setStudentScoreService(StudentScoreService studentScoreService) {
		this.studentScoreService = studentScoreService;
	}
	
	@RequestMapping(value="/score.do", method=RequestMethod.GET)
	public String getList(@RequestParam(value="user_id") int userId, 
						  @RequestParam(value="c_id") int courseId, Model model) {
		List<StudentScore> list = studentScoreService.getScoreList(courseId);
		model.addAttribute("list", list);
		model.addAttribute("id", userId);
		model.addAttribute("courseId", courseId);
		return "score";
	}

}
