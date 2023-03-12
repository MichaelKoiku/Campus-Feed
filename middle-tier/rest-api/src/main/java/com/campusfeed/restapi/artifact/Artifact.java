package com.campusfeed.restapi.artifact;

import java.sql.Timestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "artifact")
public class Artifact {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long artifact_id;
	
	@Column(name = "username", nullable = false)
	private String username;
	
	@Column(name = "title", nullable = false)
	private String title;

	@Column(name = "content", nullable = false)
	private String content;
	
	@Column(name = "external_url")
	private String externalURL;
	
	@Column(name = "category")
	private String category;
	
	@Column(name = "status")
	private String status;
	
	@Column(name = "location")
	private String location;
	
	@Column(name = "artifact_date_time")
	private Timestamp artifactDateTime;
	
	@Column(name = "date_time_created")
	private Timestamp dateTimeCreated;
	
	@Column(name = "media_url")
	private String mediaUrl;

	public long getArtifact_id() {
		return artifact_id;
	}

	public void setArtifact_id(long artifact_id) {
		this.artifact_id = artifact_id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getExternalURL() {
		return externalURL;
	}

	public void setExternalURL(String externalURL) {
		this.externalURL = externalURL;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public Timestamp getArtifactDateTime() {
		return artifactDateTime;
	}

	public void setArtifactDateTime(Timestamp artifactDateTime) {
		this.artifactDateTime = artifactDateTime;
	}

	public Timestamp getDateTimeCreated() {
		return dateTimeCreated;
	}

	public void setDateTimeCreated(Timestamp dateTimeCreated) {
		this.dateTimeCreated = dateTimeCreated;
	}

	public String getMediaUrl() {
		return mediaUrl;
	}

	public void setMediaUrl(String mediaUrl) {
		this.mediaUrl = mediaUrl;
	}
	
}
