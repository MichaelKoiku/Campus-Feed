package com.michaelkoiku.springboot.service;

import java.util.List;

import com.michaelkoiku.springboot.model.Comment;

public interface CommentService {

	Comment saveComment(Comment comment);
	List<Comment> getAllComments();
	Comment getCommentById(long id);
	Comment updateComment(Comment comment, long id);
	void deleteComment(long id);
}
