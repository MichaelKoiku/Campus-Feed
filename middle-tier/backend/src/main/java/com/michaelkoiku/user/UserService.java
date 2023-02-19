package com.michaelkoiku.user;

import java.util.List;

//This class implements the Singleton design pattern
public class UserService {
	private static UserService instance;
	private UserRepository userRepository;
	
	
	private UserService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	
	public static UserService getInstance(UserRepository userRepository) {
		if(instance == null) {
			instance = new UserService(userRepository);
		}
		
		return instance;
	}
	
	public User saveUser(User user) {
		return userRepository.save(user);
	}
	
	public List<User> getAllUsers() {
		return userRepository.findAll();
	}
	
	public User getUserById(long id) {
		return userRepository.findById(id).orElseThrow();
	}
	
	public User updateUser(User user, long id) {
		//Step 1: Check if existing user exists
		User existingUser = userRepository.findById(id).orElseThrow();
		
		//Step 2: Update the existing user's parameters
		existingUser.setPassword(user.getPassword());
		existingUser.setBio(user.getBio());
		existingUser.setDepartment(user.getDepartment());
		
		//Step 3: Save the user to DB
		userRepository.save(existingUser);
		
		//Step 4: Return existing user
		return existingUser;
	}
	
	public void deleteUser(long id) {
		//Step 1: Check if a user with a given id exists
		userRepository.findById(id).orElseThrow();
		
		//Step 2: Delete existing user
		userRepository.deleteById(id);
	}
}
