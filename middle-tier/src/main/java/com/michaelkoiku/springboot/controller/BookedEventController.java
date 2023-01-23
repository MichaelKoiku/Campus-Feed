package com.michaelkoiku.springboot.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.michaelkoiku.springboot.model.BookedEvent;
import com.michaelkoiku.springboot.service.BookedEventService;

@RestController
@RequestMapping("/api/bookedevent")
public class BookedEventController {

	private BookedEventService bookedEventService;

	public BookedEventController(BookedEventService bookedEventService) {
		super();
		this.bookedEventService = bookedEventService;
	}
	
	//Build create booked event REST API
	@PostMapping
	public ResponseEntity<BookedEvent> saveBookedEvent(@RequestBody BookedEvent bookedEvent){
		return new ResponseEntity<BookedEvent>(bookedEventService.saveBookedEvent(bookedEvent), HttpStatus.CREATED);
	}
					
	//Build get all booked events REST API
	@GetMapping
	public List<BookedEvent> getAllBookedEvents(){
		return bookedEventService.getAllBookedEvents();
	}
	
	//Build delete booked event REST API
	//http://linktomiddletier/api/bookedevent/1
	@DeleteMapping("{id}")
	public ResponseEntity<String> deleteEvent(@PathVariable("id") long id) {
		bookedEventService.deleteBookedEvent(id);
					
		return new ResponseEntity<String>("Booked Event deleted successfully!.", HttpStatus.OK);
	}
}
