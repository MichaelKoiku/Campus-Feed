package com.campusfeed.restapi.artifact;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


public interface ArtifactRepository extends JpaRepository<Artifact, Long>{
	List<Artifact> findByUsername(String username);
}
