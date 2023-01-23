package com.michaelkoiku.springboot.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.michaelkoiku.springboot.exception.ResourceNotFoundException;
import com.michaelkoiku.springboot.model.Event;
import com.michaelkoiku.springboot.repository.EventRepository;
import com.michaelkoiku.springboot.service.EventService;

@Service
public class EventServiceImpl implements EventService {
	private EventRepository eventRepository;

	public EventServiceImpl(EventRepository eventRepository) {
		super();
		this.eventRepository = eventRepository;
	}

	@Override
	public Event saveEvent(Event event) {
		return eventRepository.save(event);
	}

	@Override
	public List<Event> getAllEvents() {
		return eventRepository.findAll();
	}

	@Override
	public Event getEventById(long id) {
		return eventRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Event", "Id", id));
	}

	@Override
	public Event updateEvent(Event event, long id) {
		//Check if event with given id exists in DB
		Event existingEvent = eventRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Event", "Id", id));
		
		//Update
		existingEvent.setEvent_title(event.getEvent_title());
		existingEvent.setEvent_description(event.getEvent_description());
		existingEvent.setEvent_date(event.getEvent_date());
		existingEvent.setEvent_time(event.getEvent_time());
		existingEvent.setEvent_location(event.getEvent_location());
		existingEvent.setEvent_status(event.getEvent_status());
		
		//Save
		eventRepository.save(event);
		
		return existingEvent;
	}

	@Override
	public void deleteEvent(long id) {
		//Check if event with given id exists in DB
		eventRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Event", "Id", id));
		
		eventRepository.deleteById(id);
	}
}
