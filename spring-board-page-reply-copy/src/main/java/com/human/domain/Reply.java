package com.human.domain;

import java.time.LocalDateTime;
import java.util.List;

import lombok.Data;

@Data
public class Reply {
	
	private int replyNo;
	private int boardNo;
	private String writer;
	private String content;
	private int groupNo;
	private int parentNo;
	private int depthNo;
	private int seqNo;
	private LocalDateTime regDate;
	private LocalDateTime updDate;
	private int subCount;			// 자식 댓글 개수
	
	// 자식 댓글 목록
	private List<Reply> subList;

}






