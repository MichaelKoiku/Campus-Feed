package com.michaelkoiku.springboot.model;

import java.sql.Timestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "post")
public class Post {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long post_id;
	
	@Column(name = "username", nullable = false)
	private String username;
	
	@Column(name = "title", nullable = false)
	private String title;
	
	@Column(name = "content", nullable = false)
	private String content;
	
	@Column(name = "date_time_created")
	private Timestamp dateTimeCreated;
	
	@Column(name = "media_url", unique = true)
	private String mediaUrl;
	
	@Column(name = "likes_count")
	private long likesCount;

	public long getPost_id() {
		return post_id;
	}

	public String getUsername() {
		return username;
	}

	public String getTitle() {
		return title;
	}

	public String getContent() {
		return content;
	}

	public Timestamp getDateTimeCreated() {
		return dateTimeCreated;
	}

	public String getMediaUrl() {
		return mediaUrl;
	}

	public long getLikesCount() {
		return likesCount;
	}

	public void setPost_id(long post_id) {
		this.post_id = post_id;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public void setDateTimeCreated(Timestamp dateTimeCreated) {
		this.dateTimeCreated = dateTimeCreated;
	}

	public void setMediaUrl(String mediaUrl) {
		this.mediaUrl = mediaUrl;
	}

	public void setLikesCount(long likesCount) {
		this.likesCount = likesCount;
	}
	
}
