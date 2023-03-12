package com.campusfeed.restapi.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.campusfeed.restapi.artifact.Artifact;
import com.campusfeed.restapi.artifact.ArtifactRepository;
import com.campusfeed.restapi.command.Invoker;
import com.campusfeed.restapi.command.student.GetHomeFeed;
import com.campusfeed.restapi.command.student.GetStudentProfile;
import com.campusfeed.restapi.command.student.Receiver;
import com.campusfeed.restapi.command.student.ViewArtifact;
import com.campusfeed.restapi.user.User;
import com.campusfeed.restapi.user.UserRepository;

@CrossOrigin
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
	public ResponseEntity<List<Artifact>> getHomeFeed() {
		//Step 1. Invoke Command
		Invoker<List<Artifact>> invoker = new Invoker<>();
		Receiver reciever = new Receiver(artifactRepository, userRepository);
		invoker.setCommand(new GetHomeFeed(reciever));

		//Step 2. Return Command Response of type ResponseEntity
		return invoker.execute();
	}
	
	@GetMapping("profile/{id}")
	public ResponseEntity<User> getStudentProfile(@PathVariable("id") long id) {
		//Step 1. Invoke Command
		Invoker<User> invoker = new Invoker<>();
		Receiver reciever = new Receiver(artifactRepository, userRepository);
		invoker.setCommand(new GetStudentProfile(reciever, id));
		
		//Step 2. Return Command Response of type ResponseEntity
		return invoker.execute();
	}
	
	@GetMapping("/artifact/{id}")
	public ResponseEntity<Artifact> viewArtifact(@PathVariable("id") long id) {
		//Step 1. Invoke Command
		Invoker<Artifact> invoker = new Invoker<>();
		Receiver reciever = new Receiver(artifactRepository, userRepository);
		invoker.setCommand(new ViewArtifact(reciever, id));
		
		//Step 2. Return Command Response of type ResponseEntity
		return invoker.execute();
	}

}

