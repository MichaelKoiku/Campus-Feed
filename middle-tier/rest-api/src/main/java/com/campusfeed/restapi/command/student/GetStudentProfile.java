package com.campusfeed.restapi.command.student;

import org.springframework.http.ResponseEntity;

import com.campusfeed.restapi.command.Command;
import com.campusfeed.restapi.user.User;

public class GetStudentProfile implements Command<User>{
	private Receiver reciever;
	private long user_id;
	
	public GetStudentProfile(Receiver reciever, long id) {
		super();
		this.reciever = reciever;
		this.user_id = id;
	}

	@Override
	public ResponseEntity<User> doAction() {
		return reciever.getStudentProfile(this.user_id);
	}

}