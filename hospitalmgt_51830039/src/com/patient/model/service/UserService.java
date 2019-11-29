package com.patient.model.service;

import java.util.List;

import com.patient.model.persistance.User;

public interface UserService {
	public  User getUser(String email,String passsword);
	public void addUser(User user);
	public List<User> getAllUser();
	}


