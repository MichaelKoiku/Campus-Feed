package com.michaelkoiku.command.proforg;

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

	public ResponseEntity<Artifact> createArtifact(Artifact artifact){
		return new ResponseEntity<Artifact>(artifactService.saveArtifact(artifact), HttpStatus.OK);
	}
	
	public ResponseEntity<List<Artifact>> getMyArtifacts(String username) {
		return new ResponseEntity<List<Artifact>>(artifactService.getAllArtifactsByUsername(username), HttpStatus.OK);
	}
}
