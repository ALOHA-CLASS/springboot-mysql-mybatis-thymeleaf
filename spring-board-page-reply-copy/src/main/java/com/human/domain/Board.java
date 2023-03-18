package com.human.domain;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class Board {
	
	private int boardNo;
	private String title;
	private String writer;
	private String content;
	private LocalDateTime regDate;
	private LocalDateTime updDate;
	

}
