package com.michaelkoiku.springboot.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.michaelkoiku.springboot.exception.ResourceNotFoundException;
import com.michaelkoiku.springboot.model.User;
import com.michaelkoiku.springboot.repository.UserRepository;
import com.michaelkoiku.springboot.service.UserService;

@Service
public class UserServiceImpl implements UserService{

	private UserRepository userRepository;
	
	public UserServiceImpl(UserRepository userRepository) {
		super();
		this.userRepository = userRepository;
	}

	@Override
	public User saveUser(User user) {
		return userRepository.save(user);
	}

	@Override
	public List<User> getAllUsers() {
		return userRepository.findAll();
	}

	@Override
	public User getUserById(long id) {
		return userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User", "Id", id));
	}

	@Override
	public User updateUser(User user, long id) {
		
		//Check if user with given id exists in DB
		User existingUser = userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User", "Id", id));
		
		//Update 
		existingUser.setPassword(user.getPassword());
		
		//Save to DB
		userRepository.save(existingUser);
		
		return existingUser;
		
	}

	@Override
	public void deleteEmployee(long id) {
		//Check if user with given id exists in DB
		userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User", "Id", id));
		
		userRepository.deleteById(id);
	}
}
