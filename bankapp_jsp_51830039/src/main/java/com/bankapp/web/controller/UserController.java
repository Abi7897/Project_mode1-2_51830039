package com.bankapp.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.bankapp.model.service.UserService;

@Controller
@RequestMapping("/admin")

public class UserController {
	@Autowired
	private UserService userService;
	
	@RequestMapping("/allusers")
	public ModelAndView getAllAppUsers(ModelAndView mv){
		mv.setViewName("all_appusers");
		mv.addObject("users", userService.findAll());
		return mv;
	}

}
