package com.michaelkoiku.command.student;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.michaelkoiku.artifact.Artifact;
import com.michaelkoiku.command.Command;

public class GetHomeFeed implements Command<List<Artifact>>{
	
	private Reciever reciever;

	public GetHomeFeed(Reciever reciever) {
		super();
		this.reciever = reciever;
	}

	@Override
	public ResponseEntity<List<Artifact>> doAction() {
		return reciever.getAllArtifacts();
	}

}
