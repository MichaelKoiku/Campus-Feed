package com.michaelkoiku.springboot.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.michaelkoiku.springboot.exception.ResourceNotFoundException;
import com.michaelkoiku.springboot.model.Reply;
import com.michaelkoiku.springboot.repository.ReplyRepository;
import com.michaelkoiku.springboot.service.ReplyService;

@Service
public class ReplyServiceImpl implements ReplyService {
	private ReplyRepository replyRepository;

	public ReplyServiceImpl(ReplyRepository replyRepository) {
		super();
		this.replyRepository = replyRepository;
	}

	@Override
	public Reply saveReply(Reply reply) {
		return replyRepository.save(reply);
	}

	@Override
	public List<Reply> getAllReplies() {
		return replyRepository.findAll();
	}

	@Override
	public Reply getReplyById(long id) {
		return replyRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Reply", "Id", id));
	}

	@Override
	public Reply updateReply(Reply reply, long id) {
		//Check if comment with given id exists in DB
		Reply existingReply = replyRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Reply", "Id", id));
						
		//Update 
		existingReply.setContent(reply.getContent());
						
		//Save to DB
		replyRepository.save(existingReply);
						
		return existingReply;
	}

	@Override
	public void deleteReply(long id) {
		//Check if post with given id exists in DB
		replyRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Reply", "Id", id));
						
		replyRepository.deleteById(id);	
		
	}
	
}
