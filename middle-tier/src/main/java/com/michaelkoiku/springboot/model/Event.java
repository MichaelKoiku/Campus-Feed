package com.michaelkoiku.springboot.model;

import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "event")
public class Event {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long event_id;
	
	@Column(name = "owner", nullable = false)
	private String owner;
	
	@Column(name = "category", nullable = false)
	private String category;
	
	@Column(name = "event_type", nullable = false)
	private String event_type;
	
	@Column(name = "event_title", nullable = false)
	private String event_title;
    
	@Column(name = "event_description", nullable = false)
	private String event_description;
    
	@Column(name = "date_time_created")
	private Timestamp dateTimeCreated;
	
	@Column(name = "event_date")
	private Date event_date;
	
	@Column(name = "event_time")
	private Time event_time;
  
	@Column(name = "event_location")
	private String event_location;
	
	@Column(name = "media_url", unique = true)
	private String mediaUrl;
	
	@Column(name = "event_status", nullable = false)
	private String event_status;
    
	@Column(name = "likes_count")
	private long likesCount;

	public long getEvent_id() {
		return event_id;
	}

	public String getOwner() {
		return owner;
	}

	public String getCategory() {
		return category;
	}

	public String getEvent_type() {
		return event_type;
	}

	public String getEvent_title() {
		return event_title;
	}

	public String getEvent_description() {
		return event_description;
	}

	public Timestamp getDateTimeCreated() {
		return dateTimeCreated;
	}

	public Date getEvent_date() {
		return event_date;
	}

	public Time getEvent_time() {
		return event_time;
	}

	public String getEvent_location() {
		return event_location;
	}

	public String getMediaUrl() {
		return mediaUrl;
	}

	public String getEvent_status() {
		return event_status;
	}

	public long getLikesCount() {
		return likesCount;
	}

	public void setEvent_id(long event_id) {
		this.event_id = event_id;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public void setEvent_type(String event_type) {
		this.event_type = event_type;
	}

	public void setEvent_title(String event_title) {
		this.event_title = event_title;
	}

	public void setEvent_description(String event_description) {
		this.event_description = event_description;
	}

	public void setDateTimeCreated(Timestamp dateTimeCreated) {
		this.dateTimeCreated = dateTimeCreated;
	}

	public void setEvent_date(Date event_date) {
		this.event_date = event_date;
	}

	public void setEvent_time(Time event_time) {
		this.event_time = event_time;
	}

	public void setEvent_location(String event_location) {
		this.event_location = event_location;
	}

	public void setMediaUrl(String mediaUrl) {
		this.mediaUrl = mediaUrl;
	}

	public void setEvent_status(String event_status) {
		this.event_status = event_status;
	}

	public void setLikesCount(long likesCount) {
		this.likesCount = likesCount;
	}
	
}
