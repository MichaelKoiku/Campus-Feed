package com.campusfeed.restapi.command.proforg;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.campusfeed.restapi.artifact.Artifact;
import com.campusfeed.restapi.command.Command;

public class GetMyArtifacts implements Command<List<Artifact>>{
	
	private Receiver reciever;
	private String username;
	
	public GetMyArtifacts(Receiver reciever, String username) {
		super();
		this.reciever = reciever;
		this.username = username;
	}

	@Override
	public ResponseEntity<List<Artifact>> doAction() {
		return reciever.getMyArtifacts(this.username);
	}
	
}