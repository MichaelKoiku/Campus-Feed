package com.michaelkoiku.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.michaelkoiku.springboot.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
