package com.patient.model.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.patient.model.persistance.User;
import com.patient.model.persistance.UserDao;


@Service
@Transactional
public class UserServiceImpl implements UserService{

	@Autowired
	private UserDao userDao;
	
	@Override
	public User getUser(String email, String passsword) {
		return userDao.getUser(email, passsword);
	}
	@Override
	public void addUser(User user) {
		userDao.addUser(user);
		
	}

	@Override
	public List<User> getAllUser() {
		
		return userDao.getAllUser();
	}

	

	

}
