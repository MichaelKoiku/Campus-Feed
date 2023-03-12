package com.campusfeed.restapi.artifact;

import java.util.List;

//This class implements the Singleton design pattern
public class ArtifactService {
	private static ArtifactService instance;
	private ArtifactRepository artifactRepository;
	
	private ArtifactService(ArtifactRepository artifactRepository) {
		this.artifactRepository = artifactRepository;
	}
	
	public static ArtifactService getInstance(ArtifactRepository artifactRepository) {
		if(instance == null) {
			instance = new ArtifactService(artifactRepository);
		}
		
		return instance;
	}
	
	public Artifact saveArtifact(Artifact artifact) {
		return artifactRepository.save(artifact);
	}
	
	public List<Artifact> getAllArtifacts() {
		return artifactRepository.findAll();
	}
	
	public List<Artifact> getAllArtifactsByUsername(String username) {
		return artifactRepository.findByUsername(username);
	}
	
	public Artifact getArtifactById(long id) {
		return artifactRepository.findById(id).orElseThrow();
	}
	
	public Artifact updateArtifact(Artifact artifact, long id) {
		//Step 1: Check if existing artifact exists
		Artifact existingArtifact = artifactRepository.findById(id).orElseThrow();
		
		//Step 2: Update the existing artifact's parameters
		existingArtifact.setTitle(artifact.getTitle());
		existingArtifact.setContent(artifact.getContent());
		existingArtifact.setExternalURL(artifact.getExternalURL());
		existingArtifact.setCategory(artifact.getCategory());
		existingArtifact.setStatus(artifact.getStatus());
		existingArtifact.setLocation(artifact.getLocation());
		existingArtifact.setArtifactDateTime(artifact.getArtifactDateTime());
		existingArtifact.setMediaUrl(artifact.getMediaUrl());
		
		//Step 3: Save the artifact to DB
		artifactRepository.save(existingArtifact);
		
		//Step 4: Return existing user
		return existingArtifact;
	}
	
	public void deleteArtifact(long id) {
		//Step 1: Check if an artifact with a given id exists
		artifactRepository.findById(id).orElseThrow();
		
		//Step 2: Delete existing artifact
		artifactRepository.deleteById(id);
	}

}