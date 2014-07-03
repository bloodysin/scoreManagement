package com.bloodysin.scoremanagement.controller;

import javax.annotation.Resource; 

import org.springframework.stereotype.Controller; 
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.bloodysin.scoremanagement.model.User;
import com.bloodysin.scoremanagement.service.*;

@Controller
public class UserController {
	
	@Resource(name="UserService")
	private UserService userService = null;
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
	@Resource(name="ScoreService")
	private ScoreService scoreService = null;
	public void setScoreService(ScoreService scoreService) {
		this.scoreService = scoreService;
	}
	
	@RequestMapping(value="/signup.do", method=RequestMethod.GET)
	public String getSignUp(Model model) {
		User user = new User();
		model.addAttribute("user", user);
		return "signup";
	}
	
	@RequestMapping(value="/signup.do", method=RequestMethod.POST)
	public String postSignUp(@ModelAttribute("user") User user, Model model) {
		model.addAttribute("user", user);
		if (userService.isUserNameExisted(user.getUserName())) {
			model.addAttribute("message", "User Name already exists!");
			return "signup";
		}
		else{
			userService.addUser(user.getUserName(), user.getPassword(), true);
			return "redirect:result.do";
		}
	}
	
	@RequestMapping(value="/login.do", method=RequestMethod.GET)
	public String getLogin(Model model) {
		User user = new User();
		model.addAttribute("user", user);
		return "login";
	}
	
	@RequestMapping(value="/login.do", method=RequestMethod.POST)
	public String postLogin(@ModelAttribute("user") User user, Model model) {
		model.addAttribute("user", user);
		if (!userService.isUserNameExisted(user.getUserName())) {
			model.addAttribute("message", "User not exists!");
			return "login";
		}
		if (!userService.validate(user.getUserName(), user.getPassword())) {
			model.addAttribute("message", "Password wrong!");
			return "login";
		}
		if (userService.isTeacher(user.getUserName())) {
			return "redirect:teacher_dashboard.do?user_id=" + userService.getUserId(user.getUserName());
		}
		else {
			return "redirect:student_dashboard.do?user_id=" + userService.getUserId(user.getUserName());
		}
	}
	
	@RequestMapping(value="/teacher_dashboard.do", method=RequestMethod.GET)
	public String teacherLogin(@RequestParam(value="user_id")int userId, Model model) {
		String userName = userService.getUserById(userId).getUserName();
		model.addAttribute("name", userName);
		model.addAttribute("id", userId);
		return "teacher_dashboard";
	}
	
	@RequestMapping(value="/add_student.do", method=RequestMethod.GET)
	public String getNewStudent(@RequestParam(value="user_id") int teacherId,
								@RequestParam(value="c_id") int courseId, Model model) {
		User user = new User();
		model.addAttribute("user", user);
		model.addAttribute("teacherId", teacherId);
		model.addAttribute("courseId", courseId);
		return "add_student";
	}
	
	@RequestMapping(value="/add_student.do", method=RequestMethod.POST)
	public String postNewStudent(@RequestParam(value="user_id") int teacherId,
								 @RequestParam(value="c_id") int courseId,
								 @ModelAttribute("user")User newStudent,
								 Model model) {
		User user = new User();
		model.addAttribute("user", user);
		model.addAttribute("teacherId", teacherId);
		model.addAttribute("courseId", courseId);
		model.addAttribute("user", newStudent);
		userService.addUser(newStudent.getUserName(), "12345", false);
		scoreService.addScore(0, courseId, userService.getUserId(newStudent.getUserName()));
		return "redirect:score.do?user_id=" + teacherId + "&c_id=" + courseId;
	}
	
}
