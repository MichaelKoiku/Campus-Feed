package com.michaelkoiku.springboot.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "booked_event")
public class BookedEvent {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long event_id;
	
	@Column(name = "attender_username", nullable = false)
	private String attender_username;
	
	@Column(name = "attender_university_email", nullable = false)
	private String attender_university_email;
	
	@Column(name = "attender_first_name", nullable = false)
	private String attender_first_name;
	
	@Column(name = "attender_last_name", nullable = false)
	private String attender_last_name;
	
	@Column(name = "event_owner", nullable = false)
	private String event_owner;

	public long getEvent_id() {
		return event_id;
	}

	public String getAttender_username() {
		return attender_username;
	}

	public String getAttender_university_email() {
		return attender_university_email;
	}

	public String getAttender_first_name() {
		return attender_first_name;
	}

	public String getAttender_last_name() {
		return attender_last_name;
	}

	public String getEvent_owner() {
		return event_owner;
	}

	public void setEvent_id(long event_id) {
		this.event_id = event_id;
	}

	public void setAttender_username(String attender_username) {
		this.attender_username = attender_username;
	}

	public void setAttender_university_email(String attender_university_email) {
		this.attender_university_email = attender_university_email;
	}

	public void setAttender_first_name(String attender_first_name) {
		this.attender_first_name = attender_first_name;
	}

	public void setAttender_last_name(String attender_last_name) {
		this.attender_last_name = attender_last_name;
	}

	public void setEvent_owner(String event_owner) {
		this.event_owner = event_owner;
	}

	
}
