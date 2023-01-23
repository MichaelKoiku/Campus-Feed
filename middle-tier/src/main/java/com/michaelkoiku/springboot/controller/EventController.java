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

import com.michaelkoiku.springboot.model.Event;
import com.michaelkoiku.springboot.service.EventService;

@RestController
@RequestMapping("/api/event")
public class EventController {

	private EventService eventService;

	public EventController(EventService eventService) {
		super();
		this.eventService = eventService;
	}
	
	//Build create event REST API
	@PostMapping
	public ResponseEntity<Event> saveEvent(@RequestBody Event event){
		return new ResponseEntity<Event>(eventService.saveEvent(event), HttpStatus.CREATED);
	}
				
	//Build get all events REST API
	@GetMapping
	public List<Event> getAllEvents(){
		return eventService.getAllEvents();
	}
				
	//Build get event by id REST API
	//http://linktomiddletier/api/event/1
	@GetMapping("{id}")
	public ResponseEntity<Event> getEventById(@PathVariable("id") long id) {
		return new ResponseEntity<Event>(eventService.getEventById(id), HttpStatus.OK);
	}
				
	//Build update event REST API
	//http://linktomiddletier/api/event/1
	@PostMapping("{id}")
	public ResponseEntity<Event> updateEvent(@PathVariable("id") long id, @RequestBody Event event) {
		return new ResponseEntity<Event>(eventService.updateEvent(event, id), HttpStatus.OK);
	}
				
	//Build delete event REST API
	//http://linktomiddletier/api/event/1
	@DeleteMapping("{id}")
	public ResponseEntity<String> deleteEvent(@PathVariable("id") long id) {
		eventService.deleteEvent(id);
				
		return new ResponseEntity<String>("Event deleted successfully!.", HttpStatus.OK);
	}

}
