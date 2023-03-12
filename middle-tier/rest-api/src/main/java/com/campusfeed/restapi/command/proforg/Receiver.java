package com.campusfeed.restapi.command.proforg;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import com.campusfeed.restapi.artifact.Artifact;
import com.campusfeed.restapi.artifact.ArtifactRepository;
import com.campusfeed.restapi.artifact.ArtifactService;
import com.campusfeed.restapi.user.UserRepository;
import com.campusfeed.restapi.user.UserService;

public class Receiver {
	private ArtifactService artifactService;
	private UserService userService;

	public Receiver(ArtifactRepository artifactRepository, UserRepository userRepository) {
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

