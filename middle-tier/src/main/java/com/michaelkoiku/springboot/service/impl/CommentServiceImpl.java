package com.michaelkoiku.springboot.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.michaelkoiku.springboot.exception.ResourceNotFoundException;
import com.michaelkoiku.springboot.model.Comment;
import com.michaelkoiku.springboot.repository.CommentRepository;
import com.michaelkoiku.springboot.service.CommentService;

@Service
public class CommentServiceImpl implements CommentService{
	private CommentRepository commentRepository;
	
	public CommentServiceImpl(CommentRepository commentRepository) {
		super();
		this.commentRepository = commentRepository;
	}

	@Override
	public Comment saveComment(Comment comment) {
		return commentRepository.save(comment);
	}

	@Override
	public List<Comment> getAllComments() {
		return commentRepository.findAll();
	}

	@Override
	public Comment getCommentById(long id) {
		return commentRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Comment", "Id", id));
	}

	@Override
	public Comment updateComment(Comment comment, long id) {
		//Check if comment with given id exists in DB
		Comment existingComment = commentRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Comment", "Id", id));
				
		//Update 
		existingComment.setContent(comment.getContent());
				
		//Save to DB
		commentRepository.save(existingComment);
				
		return existingComment;
	}

	@Override
	public void deleteComment(long id) {
		//Check if post with given id exists in DB
		commentRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Comment", "Id", id));
				
		commentRepository.deleteById(id);	
	}
	
}
