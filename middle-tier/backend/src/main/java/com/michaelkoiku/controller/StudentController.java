package com.michaelkoiku.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.michaelkoiku.artifact.Artifact;
import com.michaelkoiku.artifact.ArtifactRepository;
import com.michaelkoiku.command.Invoker;
import com.michaelkoiku.command.student.GetHomeFeed;
import com.michaelkoiku.command.student.Reciever;
import com.michaelkoiku.user.UserRepository;

@RestController
@RequestMapping("/api/student/")
public class StudentController {
	private ArtifactRepository artifactRepository;
	private UserRepository userRepository;
	
	public StudentController(ArtifactRepository artifactRepository, UserRepository userRepository) {
		super();
		this.artifactRepository = artifactRepository;
		this.artifactRepository = artifactRepository;
	}

	@GetMapping("home")
	public ResponseEntity<List<Artifact>> getHomePage() {
		//Step 1. Invoke Command
		Invoker<List<Artifact>> invoker = new Invoker<>();
		Reciever reciever = new Reciever(artifactRepository, userRepository);
		invoker.setCommand(new GetHomeFeed(reciever));

		//Step 2. Return Command Response of type ResponseEntity
		//return new ResponseEntity<String>("Home Page End Point Hit.", HttpStatus.OK);
		return invoker.execute();
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
