package com.campusfeed.restapi.command.proforg;

import org.springframework.http.ResponseEntity;

import com.campusfeed.restapi.artifact.Artifact;
import com.campusfeed.restapi.command.Command;

public class CreateArtifact implements Command<Artifact>{
	
	private Receiver reciever;
	private Artifact artifact;
	
	public CreateArtifact(Receiver reciever, Artifact artifact) {
		super();
		this.reciever = reciever;
		this.artifact = artifact;
	}
	@Override
	public ResponseEntity<Artifact> doAction() {
		return reciever.createArtifact(this.artifact);
	}
}
