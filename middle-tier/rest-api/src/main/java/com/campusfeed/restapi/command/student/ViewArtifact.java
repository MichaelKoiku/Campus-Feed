package com.campusfeed.restapi.command.student;

import org.springframework.http.ResponseEntity;

import com.campusfeed.restapi.artifact.Artifact;
import com.campusfeed.restapi.command.Command;

public class ViewArtifact implements Command<Artifact>{
	private Receiver reciever;
	private long artifact_id;
	
	public ViewArtifact(Receiver reciever, long artifact_id) {
		super();
		this.reciever = reciever;
		this.artifact_id = artifact_id;
	}

	@Override
	public ResponseEntity<Artifact> doAction() {
		return reciever.getArtifact(this.artifact_id);
	}	
}
