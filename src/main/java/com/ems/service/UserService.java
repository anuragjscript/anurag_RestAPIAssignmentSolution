package com.ems.service;

import java.util.List;

import com.ems.model.User;

public interface UserService {

	List<User> getAllUsers();
	
	User getUserById(Integer userId);
	
	User saveUser(User user);
	
	void deleteUserById(Integer userId);
	
}
