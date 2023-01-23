package com.michaelkoiku.springboot.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.michaelkoiku.springboot.model.User;
import com.michaelkoiku.springboot.service.UserService;

@RestController
@RequestMapping("/api/user")
public class UserController {
	 
	private UserService userService;

	public UserController(UserService userService) {
		super();
		this.userService = userService;
	}
	
	
	//Build create user REST API
	@PostMapping
	public ResponseEntity<User> saveUser(@RequestBody User user){
		return new ResponseEntity<User>(userService.saveUser(user), HttpStatus.CREATED);
	}
	
	//Build get all users REST API
	@GetMapping
	public List<User> getAllUsers() {
		return userService.getAllUsers();
	}
	
	//Build get user by id REST API
	//http://linktomiddletier/api/user/1
	@GetMapping("{id}")
	public ResponseEntity<User> getUserById(@PathVariable("id") long id) {
		return new ResponseEntity<User>(userService.getUserById(id), HttpStatus.OK);
	}
	
	//Build update user REST API
	//http://linktomiddletier/api/user/1
	@PostMapping("{id}")
	public ResponseEntity<User> updateUser(@PathVariable("id") long id, @RequestBody User user) {
		return new ResponseEntity<User>(userService.updateUser(user, id), HttpStatus.OK);
	}
	
	//Build delete user REST API
	//http://linktomiddletier/api/user/1
	@DeleteMapping("{id}")
	public ResponseEntity<String> deleteUser(@PathVariable("id") long id) {
		userService.deleteEmployee(id);
		
		return new ResponseEntity<String>("User deleted successfully!.", HttpStatus.OK);
	}
}
