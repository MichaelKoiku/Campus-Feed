package com.michaelkoiku.springboot.service;

import java.util.List;

import com.michaelkoiku.springboot.model.Reply;

public interface ReplyService {
	
	Reply saveReply(Reply reply);
	List<Reply> getAllReplies();
	Reply getReplyById(long id);
	Reply updateReply(Reply reply, long id);
	void deleteReply(long id);

}
