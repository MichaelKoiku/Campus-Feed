package com.michaelkoiku.command.student;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.michaelkoiku.artifact.Artifact;
import com.michaelkoiku.artifact.ArtifactRepository;
import com.michaelkoiku.artifact.ArtifactService;
import com.michaelkoiku.user.UserRepository;
import com.michaelkoiku.user.UserService;

//This class implements the Command design pattern
public class Reciever {
	private ArtifactService artifactService;
	private UserService userService;
	
	public Reciever(ArtifactRepository artifactRepository, UserRepository userRepository) {
		this.artifactService = ArtifactService.getInstance(artifactRepository);
		this.userService = UserService.getInstance(userRepository);
	}
	
	public ResponseEntity<List<Artifact>> getAllArtifacts(){
		return new ResponseEntity<List<Artifact>>(artifactService.getAllArtifacts(), HttpStatus.OK);
	}

}
