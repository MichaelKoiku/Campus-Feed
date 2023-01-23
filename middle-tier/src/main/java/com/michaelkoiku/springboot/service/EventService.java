package com.michaelkoiku.springboot.service;

import java.util.List;

import com.michaelkoiku.springboot.model.Event;

public interface EventService {

	Event saveEvent(Event event);
	List<Event> getAllEvents();
	Event getEventById(long id);
	Event updateEvent(Event event, long id);
	void deleteEvent(long id);
}
