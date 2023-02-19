package com.michaelkoiku.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/student/")
public class StudentController {
	
	@GetMapping("home")
	public ResponseEntity<String> getHomePage() {
		//Step 1. Invoke Command
		
		//Step 2. Return Command Response of type ResponseEntity
		return new ResponseEntity<String>("Home Page End Point Hit.", HttpStatus.OK);
	}
	
	@GetMapping("profile")
	public ResponseEntity<String> getStudentProfile() {
		//Step 1. Invoke Command
		
		//Step 2. Return Command Response of type ResponseEntity
		return new ResponseEntity<String>("Student Profile End Point Hit.", HttpStatus.OK);
	}
	
	@GetMapping("/artifact/{id}")
	public ResponseEntity<String> viewArtifact(@PathVariable("id") long id) {
		//Step 1. Invoke Command
		
		//Step 2. Return Command Response of type ResponseEntity
		return new ResponseEntity<String>("View Artifact End Point Hit.", HttpStatus.OK);
	}

}
