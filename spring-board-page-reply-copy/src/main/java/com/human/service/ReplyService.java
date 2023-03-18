package com.human.service;

import java.util.List;

import com.human.domain.Reply;

public interface ReplyService {

	// 댓글 전체 조회
	public List<Reply> list() throws Exception;
	
	// 댓글 목록 - 게시글 번호
	public List<Reply> list(int boardNo) throws Exception;
	
	// 댓글 등록
	public int insert(Reply reply) throws Exception;
	
	// 댓글 수정
	public int update(Reply reply) throws Exception;
	
	// 댓글 삭제
	public int delete(int replyNo) throws Exception;
	
	// 답글 등록
	public int insertAnswer(Reply reply) throws Exception;
	
	
}
