package com.campusfeed.restapi.command.student;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.campusfeed.restapi.artifact.Artifact;
import com.campusfeed.restapi.artifact.ArtifactRepository;
import com.campusfeed.restapi.artifact.ArtifactService;
import com.campusfeed.restapi.user.User;
import com.campusfeed.restapi.user.UserRepository;
import com.campusfeed.restapi.user.UserService;

//This class implements the Command design pattern
public class Receiver {
	private ArtifactService artifactService;
	private UserService userService;
	
	public Receiver(ArtifactRepository artifactRepository, UserRepository userRepository) {
		this.artifactService = ArtifactService.getInstance(artifactRepository);
		this.userService = UserService.getInstance(userRepository);
	}
	
	public ResponseEntity<List<Artifact>> getAllArtifacts(){
		return new ResponseEntity<List<Artifact>>(artifactService.getAllArtifacts(), HttpStatus.OK);
	}
	
	public ResponseEntity<User> getStudentProfile(long id) {
		return new ResponseEntity<User>(userService.getUserById(id), HttpStatus.OK);
	}

	public ResponseEntity<Artifact> getArtifact(long id) {
		return new ResponseEntity<Artifact>(artifactService.getArtifactById(id), HttpStatus.OK);
	}
}
