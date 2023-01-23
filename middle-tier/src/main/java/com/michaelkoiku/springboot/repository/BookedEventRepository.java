package com.michaelkoiku.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.michaelkoiku.springboot.model.BookedEvent;

public interface BookedEventRepository extends JpaRepository<BookedEvent, Long>{

}
