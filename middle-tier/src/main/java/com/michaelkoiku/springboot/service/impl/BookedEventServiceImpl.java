package com.michaelkoiku.springboot.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.michaelkoiku.springboot.exception.ResourceNotFoundException;
import com.michaelkoiku.springboot.model.BookedEvent;
import com.michaelkoiku.springboot.repository.BookedEventRepository;
import com.michaelkoiku.springboot.service.BookedEventService;

@Service
public class BookedEventServiceImpl implements BookedEventService{
	private BookedEventRepository bookedEventRepository;

	public BookedEventServiceImpl(BookedEventRepository bookedEventRepository) {
		super();
		this.bookedEventRepository = bookedEventRepository;
	}

	@Override
	public BookedEvent saveBookedEvent(BookedEvent bookedEvent) {
		return bookedEventRepository.save(bookedEvent);
	}

	@Override
	public List<BookedEvent> getAllBookedEvents() {
		return bookedEventRepository.findAll();
	}

	@Override
	public void deleteBookedEvent(long id) {
		//Check if booked event with given id exists in DB
		bookedEventRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Booked Event", "Id", id));
				
		bookedEventRepository.deleteById(id);
	
	}
	
}
