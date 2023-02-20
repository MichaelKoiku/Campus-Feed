package com.michaelkoiku.command.student;

import org.springframework.http.ResponseEntity;

import com.michaelkoiku.command.Command;
import com.michaelkoiku.user.User;

public class GetStudentProfile implements Command<User>{
	private Reciever reciever;
	private long user_id;
	
	public GetStudentProfile(Reciever reciever, long id) {
		super();
		this.reciever = reciever;
		this.user_id = id;
	}

	@Override
	public ResponseEntity<User> doAction() {
		return reciever.getStudentProfile(this.user_id);
	}

}
