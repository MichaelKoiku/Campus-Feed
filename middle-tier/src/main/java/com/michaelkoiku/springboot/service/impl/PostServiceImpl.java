package com.michaelkoiku.springboot.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.michaelkoiku.springboot.exception.ResourceNotFoundException;
import com.michaelkoiku.springboot.model.Post;
import com.michaelkoiku.springboot.repository.PostRepository;
import com.michaelkoiku.springboot.service.PostService;

@Service
public class PostServiceImpl implements PostService{
	
	private PostRepository postRepository;
	
	public PostServiceImpl(PostRepository postRepository) {
		super();
		this.postRepository = postRepository;
	}

	@Override
	public Post savePost(Post post) {
		return postRepository.save(post);
	}

	@Override
	public List<Post> getAllPosts() {
		return postRepository.findAll();
	}

	@Override
	public Post getPostById(long id) {
		return postRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Post", "Id", id));
	}

	@Override
	public Post updatePost(Post post, long id) {
		
		//Check if post with given id exists in DB
		Post existingPost = postRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Post", "Id", id));
		
		//Update 
		existingPost.setTitle(post.getTitle());
		existingPost.setContent(post.getContent());
		
		//Save to DB
		postRepository.save(existingPost);
		
		return existingPost;
		
	}

	@Override
	public void deletePost(long id) {
		//Check if post with given id exists in DB
		postRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Post", "Id", id));
		
		postRepository.deleteById(id);
	}
	
}
