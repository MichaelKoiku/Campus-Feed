package com.campusfeed.restapi.command.proforg;

import org.springframework.http.ResponseEntity;

import com.campusfeed.restapi.command.Command;

public class DeleteArtifact implements Command<Void>{
	
	private Receiver reciever;
	private long artifactId;
	
	public DeleteArtifact(Receiver receiver, long id) {
		this.reciever = receiver;
		this.artifactId = id;
	}

	@Override
	public ResponseEntity<Void> doAction() {
		try {
			reciever.deleteArtifact(artifactId);
			  return ResponseEntity.noContent().build();
			 } catch (Exception e) {
			  return ResponseEntity.notFound().build();
		}
	}
}
