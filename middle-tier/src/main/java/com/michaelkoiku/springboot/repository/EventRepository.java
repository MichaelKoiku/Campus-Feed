package com.michaelkoiku.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.michaelkoiku.springboot.model.Event;

public interface EventRepository extends JpaRepository<Event, Long>{

}
