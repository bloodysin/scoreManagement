package com.bloodysin.scoremanagement.controller;

import javax.annotation.Resource; 
import org.springframework.stereotype.Controller; 
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.bloodysin.scoremanagement.service.TestService;

@Controller 
@RequestMapping("/result.do") 
public class ResultController { 
    //将spring 配置文件中的bean 通过setter注入进来 
    @Resource(name="TestService") 
    private TestService testService=null; 
    public void setTestService(TestService testService) { 
        this.testService = testService; 
    }

    @RequestMapping 
    public String viewUser(@RequestParam(value="name") String name, Model model)  { 
    	model.addAttribute("name", name);
        return "result"; 
    } 
}