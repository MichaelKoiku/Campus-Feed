package com.michaelkoiku.factory;

import com.michaelkoiku.artifact.Artifact;

//This class implements the Factory Method and Singleton design pattern
public class ArtifactFactory extends Factory {
	private static ArtifactFactory instance;
	
	private ArtifactFactory() {}
	
	public static ArtifactFactory getInstance() {
		if(instance == null) {
			instance = new ArtifactFactory();
		}
		return instance;
	}
	
	@Override
	public Entity createEntity() {
		return new Artifact();
	}

}
