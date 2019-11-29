package com.bankapp.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bankapp.model.entities.User;
import com.bankapp.model.service.UserService;

@RestController
@RequestMapping(path="/app/user")
public class UserRestController {
	@Autowired
	private UserService userService;
	
	@GetMapping(path="allusers",produces=MediaType.APPLICATION_JSON_VALUE)
	public List<User> getAlluser(){
		return userService.findAll();
	}

}
