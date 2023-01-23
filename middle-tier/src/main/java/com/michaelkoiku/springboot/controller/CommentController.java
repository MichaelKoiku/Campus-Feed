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

import com.michaelkoiku.springboot.model.Comment;
import com.michaelkoiku.springboot.service.CommentService;

@RestController
@RequestMapping("/api/comment")
public class CommentController {
	
	private CommentService commentService;
	
	public CommentController (CommentService commentService) {
		super();
		this.commentService = commentService;
	}
	
	
	//Build create comment REST API
	@PostMapping
	public ResponseEntity<Comment> saveComment(@RequestBody Comment comment){
		return new ResponseEntity<Comment>(commentService.saveComment(comment), HttpStatus.CREATED);
	}
			
	//Build get all comments REST API
	@GetMapping
	public List<Comment> getAllComments(){
		return commentService.getAllComments();
	}
			
	//Build get comment by id REST API
	//http://linktomiddletier/api/comment/1
	@GetMapping("{id}")
	public ResponseEntity<Comment> getCommentById(@PathVariable("id") long id) {
		return new ResponseEntity<Comment>(commentService.getCommentById(id), HttpStatus.OK);
	}
			
	//Build update comment REST API
	//http://linktomiddletier/api/comment/1
	@PostMapping("{id}")
	public ResponseEntity<Comment> updateComment(@PathVariable("id") long id, @RequestBody Comment comment) {
		return new ResponseEntity<Comment>(commentService.updateComment(comment, id), HttpStatus.OK);
	}
			
	//Build delete comment REST API
	//http://linktomiddletier/api/comment/1
	@DeleteMapping("{id}")
	public ResponseEntity<String> deleteComment(@PathVariable("id") long id) {
		commentService.deleteComment(id);
				
		return new ResponseEntity<String>("Comment deleted successfully!.", HttpStatus.OK);
	}
}
