package com.michaelkoiku.springboot.service;

import java.util.List;

import com.michaelkoiku.springboot.model.Post;

public interface PostService {
	
	Post savePost(Post post);
	List<Post> getAllPosts();
	Post getPostById(long id);
	Post updatePost(Post post, long id);
	void deletePost(long id);
}
