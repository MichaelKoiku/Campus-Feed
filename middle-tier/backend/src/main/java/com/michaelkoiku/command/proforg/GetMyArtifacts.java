package com.michaelkoiku.command.proforg;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.michaelkoiku.artifact.Artifact;
import com.michaelkoiku.command.Command;

public class GetMyArtifacts implements Command<List<Artifact>>{
	
	private Reciever reciever;
	private String username;
	
	public GetMyArtifacts(Reciever reciever, String username) {
		super();
		this.reciever = reciever;
		this.username = username;
	}

	@Override
	public ResponseEntity<List<Artifact>> doAction() {
		return reciever.getMyArtifacts(this.username);
	}
	
}
