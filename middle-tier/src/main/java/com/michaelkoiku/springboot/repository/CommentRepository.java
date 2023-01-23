package com.michaelkoiku.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.michaelkoiku.springboot.model.Comment;

public interface CommentRepository extends JpaRepository<Comment,Long>{
	

}
