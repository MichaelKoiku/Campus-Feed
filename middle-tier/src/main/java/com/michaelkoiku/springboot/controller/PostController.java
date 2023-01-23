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

import com.michaelkoiku.springboot.model.Post;
import com.michaelkoiku.springboot.service.PostService;

@RestController
@RequestMapping("/api/post")
public class PostController {
	
	private PostService postService;
	
	public PostController (PostService postService) {
		super();
		this.postService = postService;
	}
	
	//Build create user REST API
	@PostMapping
	public ResponseEntity<Post> savePost(@RequestBody Post post){
		return new ResponseEntity<Post>(postService.savePost(post), HttpStatus.CREATED);
	}
		
	//Build get all posts REST API
	@GetMapping
	public List<Post> getAllPosts(){
		return postService.getAllPosts();
	}
		
	//Build get post by id REST API
	//http://linktomiddletier/api/post/1
	@GetMapping("{id}")
	public ResponseEntity<Post> getPostById(@PathVariable("id") long id) {
		return new ResponseEntity<Post>(postService.getPostById(id), HttpStatus.OK);
	}
		
	//Build update post REST API
	//http://linktomiddletier/api/post/1
	@PostMapping("{id}")
	public ResponseEntity<Post> updatePost(@PathVariable("id") long id, @RequestBody Post post) {
		return new ResponseEntity<Post>(postService.updatePost(post, id), HttpStatus.OK);
	}
		
	//Build delete post REST API
	//http://linktomiddletier/api/post/1
	@DeleteMapping("{id}")
	public ResponseEntity<String> deletePost(@PathVariable("id") long id) {
		postService.deletePost(id);
			
		return new ResponseEntity<String>("Post deleted successfully!.", HttpStatus.OK);
	}
}
