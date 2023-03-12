package com.campusfeed.restapi.command;

import org.springframework.http.ResponseEntity;

//This class implements the Command design pattern
public class Invoker<T> {
	
	private Command<T> command;

	public Command<T> getCommand() {
		return command;
	}

	public void setCommand(Command<T> command) {
		this.command = command;
	}
	
	public ResponseEntity<T> execute() {
		return command.doAction();
	}

}
