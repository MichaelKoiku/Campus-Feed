package com.michaelkoiku.springboot.model;

import java.sql.Timestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "reply")
public class Reply {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long reply_id;
	
	@Column(name = "comment_id", nullable = false)
	private long comment_id;
	
	@Column(name = "username", nullable = false)
	private String username;
	
	@Column(name = "content", nullable = false)
	private String content;
	
	@Column(name = "date_time_created")
	private Timestamp dateTimeCreated;

	public long getReply_id() {
		return reply_id;
	}

	public long getComment_id() {
		return comment_id;
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

	public void setReply_id(long reply_id) {
		this.reply_id = reply_id;
	}

	public void setComment_id(long comment_id) {
		this.comment_id = comment_id;
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
