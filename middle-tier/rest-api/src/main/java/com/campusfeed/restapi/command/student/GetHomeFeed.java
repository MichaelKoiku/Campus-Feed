package com.campusfeed.restapi.command.student;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.campusfeed.restapi.artifact.Artifact;
import com.campusfeed.restapi.command.Command;

public class GetHomeFeed implements Command<List<Artifact>>{
	
	private Receiver reciever;

	public GetHomeFeed(Receiver reciever) {
		super();
		this.reciever = reciever;
	}

	@Override
	public ResponseEntity<List<Artifact>> doAction() {
		return reciever.getAllArtifacts();
	}

}
