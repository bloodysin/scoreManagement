package com.bloodysin.scoremanagement.controller;

import java.util.List;

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
public class CourseController {
	
	@Resource(name="CourseService")
	private CourseService courseService = null;
	public void setCourseService(CourseService courseService) {
		this.courseService = courseService;
	}
	
	@RequestMapping(value="/course.do", method=RequestMethod.GET)
	public String getList(@RequestParam(value="user_id") int userId, Model model) {
		List<Course> list = courseService.getCourseList(userId);
		model.addAttribute("list", list);
		model.addAttribute("id", userId);
		return "course";
	}
	
	@RequestMapping(value="/add_course.do", method=RequestMethod.GET)
	public String getNewStudent(@RequestParam(value="user_id") int teacherId, Model model) {
		Course course = new Course();
		model.addAttribute("course", course);
		model.addAttribute("teacherId", teacherId);
		return "add_course";
	}
	
	@RequestMapping(value="/add_course.do", method=RequestMethod.POST)
	public String postNewStudent(@RequestParam(value="user_id") int teacherId,
								 @ModelAttribute("course")Course newCourse,
								 Model model) {
		User user = new User();
		model.addAttribute("user", user);
		model.addAttribute("teacherId", teacherId);
		model.addAttribute("course", newCourse);
		courseService.addCourse(newCourse.getCourseName(), teacherId);
		return "redirect:course.do?user_id=" + teacherId;
	}
	

}