package com.michaelkoiku.command.proforg;

import org.springframework.http.ResponseEntity;

import com.michaelkoiku.artifact.Artifact;
import com.michaelkoiku.command.Command;

public class CreateArtifact implements Command<Artifact>{
	
	private Reciever reciever;
	private Artifact artifact;
	
	public CreateArtifact(Reciever reciever, Artifact artifact) {
		super();
		this.reciever = reciever;
		this.artifact = artifact;
	}
	@Override
	public ResponseEntity<Artifact> doAction() {
		return reciever.createArtifact(this.artifact);
	}
}
