package com.patient.model.persistance;

import java.util.List;

public interface UserDao {
public User getUser(String email,String passsword);
public void addUser(User user);
public List<User> getAllUser();
}
