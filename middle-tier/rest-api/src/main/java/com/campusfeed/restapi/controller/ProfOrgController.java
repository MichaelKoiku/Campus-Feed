package com.campusfeed.restapi.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.campusfeed.restapi.artifact.Artifact;
import com.campusfeed.restapi.artifact.ArtifactRepository;
import com.campusfeed.restapi.command.Invoker;
import com.campusfeed.restapi.command.proforg.CreateArtifact;
import com.campusfeed.restapi.command.proforg.DeleteArtifact;
import com.campusfeed.restapi.command.proforg.GetMyArtifacts;
import com.campusfeed.restapi.command.proforg.Receiver;
import com.campusfeed.restapi.user.UserRepository;

@CrossOrigin
@RestController
@RequestMapping("/api/proforg/")
public class ProfOrgController {
	private ArtifactRepository artifactRepository;
	private UserRepository userRepository;
	
	public ProfOrgController(ArtifactRepository artifactRepository, UserRepository userRepository) {
		super();
		this.artifactRepository = artifactRepository;
		this.userRepository = userRepository;
	}
	
	@PostMapping("create")
	public ResponseEntity<Artifact> createArtifact(@RequestBody Artifact artifact){
		//Step 1. Invoke Command
		Invoker<Artifact> invoker = new Invoker<>();
		Receiver reciever = new Receiver(artifactRepository, userRepository);
		invoker.setCommand(new CreateArtifact(reciever, artifact));
		
		//Step 2. Return Command Response of type ResponseEntity
		return invoker.execute();
	}
	
	@GetMapping("myartifacts/{username}")
	public ResponseEntity<List<Artifact>> getMyArtifacts(@PathVariable("username") String username) {
		//Step 1. Invoke Command
		Invoker<List<Artifact>> invoker = new Invoker<>();
		Receiver reciever = new Receiver(artifactRepository, userRepository);
		invoker.setCommand(new GetMyArtifacts(reciever, username));
		
		//Step 2. Return Command Response of type ResponseEntity
		return invoker.execute();
	}
	
	@DeleteMapping("myartifacts/{id}")
	public ResponseEntity<Void> deleteArtifact(@PathVariable long id){
		//Step 1. Invoke Command
		Invoker<Void> invoker = new Invoker<>();
		Receiver receiver = new Receiver(artifactRepository, userRepository);
		invoker.setCommand(new DeleteArtifact(receiver, id));
		
		//Step 2. Return Command Response of type ResponseEntity
		return invoker.execute();
	}
	
}

