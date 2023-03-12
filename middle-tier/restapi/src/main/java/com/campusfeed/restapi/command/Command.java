package com.campusfeed.restapi.command;

import org.springframework.http.ResponseEntity;

//This class implements the Command design patterns
public interface Command<T> {

	public ResponseEntity<T> doAction();
}
