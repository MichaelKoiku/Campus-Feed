package com.campusfeed.restapi.command.proforg;

import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import com.campusfeed.restapi.artifact.Artifact;
import com.campusfeed.restapi.command.Command;

public class CreateArtifact implements Command<Artifact>{
	
	private Receiver reciever;
	private Artifact artifact;
	private MultipartFile file;
	
	public CreateArtifact(Receiver reciever, Artifact artifact, MultipartFile file) {
		super();
		this.reciever = reciever;
		this.artifact = artifact;
		this.file = file;
	}
	@Override
	public ResponseEntity<Artifact> doAction() {
		return reciever.createArtifact(this.artifact, this.file);
	}
}
