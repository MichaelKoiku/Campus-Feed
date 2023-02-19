package com.michaelkoiku.factory;

import com.michaelkoiku.artifact.Artifact;

//This class implements the Factory Method design pattern
public class ArtifactFactory extends Factory {

	@Override
	public Entity createEntity() {
		return new Artifact();
	}

}
