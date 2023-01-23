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

import com.michaelkoiku.springboot.model.Reply;
import com.michaelkoiku.springboot.service.ReplyService;

@RestController
@RequestMapping("/api/reply")
public class ReplyController {

	private ReplyService replyService;

	public ReplyController(ReplyService replyService) {
		super();
		this.replyService = replyService;
	}
	
	//Build create reply REST API
	@PostMapping
	public ResponseEntity<Reply> saveReply(@RequestBody Reply reply){
		return new ResponseEntity<Reply>(replyService.saveReply(reply), HttpStatus.CREATED);
	}
	
	//Build get all replies REST API
	@GetMapping
	public List<Reply> getAllReplies(){
		return replyService.getAllReplies();
	}
	
	//Build get reply by id REST API
	//http://linktomiddletier/api/reply/1
	@GetMapping("{id}")
	public ResponseEntity<Reply> getReplyById(@PathVariable("id") long id) {
		return new ResponseEntity<Reply>(replyService.getReplyById(id), HttpStatus.OK);
	}
	
	//Build update reply REST API
	//http://linktomiddletier/api/reply/1
	@PostMapping("{id}")
	public ResponseEntity<Reply> updateReply(@PathVariable("id") long id, @RequestBody Reply reply) {
		return new ResponseEntity<Reply>(replyService.updateReply(reply, id), HttpStatus.OK);
	}
				
	//Build delete reply REST API
	//http://linktomiddletier/api/reply/1
	@DeleteMapping("{id}")
	public ResponseEntity<String> deleteReply(@PathVariable("id") long id) {
		replyService.deleteReply(id);
				
		return new ResponseEntity<String>("Reply deleted successfully!.", HttpStatus.OK);
	}
}
