package com.michaelkoiku.springboot.model;

import java.sql.Timestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "comment")
public class Comment {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long comment_id;
	
	@Column(name = "post_id", nullable = false)
	private long post_id;
	
	@Column(name = "username", nullable = false)
	private String username;
	
	@Column(name = "content", nullable = false)
	private String content;
	
	@Column(name = "date_time_created")
	private Timestamp dateTimeCreated;

	public long getComment_id() {
		return comment_id;
	}

	public long getPost_id() {
		return post_id;
	}

	public String getUsername() {
		return username;
	}

	public String getContent() {
		return content;
	}

	public Timestamp getDateTimeCreated() {
		return dateTimeCreated;
	}

	public void setComment_id(long comment_id) {
		this.comment_id = comment_id;
	}

	public void setPost_id(long post_id) {
		this.post_id = post_id;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public void setDateTimeCreated(Timestamp dateTimeCreated) {
		this.dateTimeCreated = dateTimeCreated;
	}
}
