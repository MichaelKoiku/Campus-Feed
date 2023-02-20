package com.michaelkoiku.command.student;

import org.springframework.http.ResponseEntity;

import com.michaelkoiku.artifact.Artifact;
import com.michaelkoiku.command.Command;

public class ViewArtifact implements Command<Artifact>{
	private Reciever reciever;
	private long artifact_id;
	
	public ViewArtifact(Reciever reciever, long artifact_id) {
		super();
		this.reciever = reciever;
		this.artifact_id = artifact_id;
	}

	@Override
	public ResponseEntity<Artifact> doAction() {
		return reciever.getArtifact(this.artifact_id);
	}	
}
