package com.michaelkoiku.springboot.service;

import java.util.List;

import com.michaelkoiku.springboot.model.User;

public interface UserService {
	
	User saveUser(User user);
	List<User> getAllUsers();
	User getUserById(long id);
	User updateUser(User user, long id);
	void deleteEmployee(long id);
}
