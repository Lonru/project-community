package com.lonru.community.service;


import java.util.List;

import com.lonru.community.domain.reply.Reply;
import com.lonru.community.domain.reply.ReplyDao;
import com.lonru.community.domain.reply.dto.SaveReqDto;

public class ReplyService {
	
	private ReplyDao replyDao;
	
	public ReplyService() {
		replyDao = new ReplyDao();
	}
	public int 댓글삭제(int id) {
		return replyDao.deleteById(id);
	}
	
	public List<Reply> 댓글전체보기(int boardId){
		return replyDao.findAll(boardId);
	}

	public Reply 댓글찾기(int id) {
		return replyDao.findById(id);
	}

	public int 댓글쓰기 (SaveReqDto dto) {
	return replyDao.save(dto);
	}
}
