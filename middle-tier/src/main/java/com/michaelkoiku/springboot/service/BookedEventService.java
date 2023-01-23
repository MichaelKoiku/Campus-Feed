package com.michaelkoiku.springboot.service;

import java.util.List;

import com.michaelkoiku.springboot.model.BookedEvent;

public interface BookedEventService {

	BookedEvent saveBookedEvent(BookedEvent bookedEvent);
	List<BookedEvent> getAllBookedEvents();
	void deleteBookedEvent(long id);
}
