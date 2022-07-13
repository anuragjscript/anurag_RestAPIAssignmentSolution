package com.ems.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ems.exception.ResourceNotFoundException;
import com.ems.model.Role;
import com.ems.model.User;
import com.ems.repository.RoleDao;
import com.ems.repository.UserDao;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;
	
	@Autowired
	private RoleDao roleDao;

	@Override
	public List<User> getAllUsers() {
		return userDao.findAll();
	}

	@Override
	public User getUserById(Integer userId) {
		return userDao.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("User", "userId", userId));
	}

	@Override
	public User saveUser(User user) {
		
		List<Role> roles = user.getRoles();
		
		if(roles != null) {
			for(Role role : roles) {
				roleDao.save(role);
			}
		}
		return userDao.save(user);
	}

	@Override
	public void deleteUserById(Integer userId) {
		User user = getUserById(userId);
		userDao.delete(user);
	}

}
