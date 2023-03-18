package com.human.service;

import java.util.List;

import com.human.domain.Board;
import com.human.domain.Option;
import com.human.domain.Page;

public interface BoardService {
	
	// 게시글 목록
	public List<Board> list() throws Exception;
	
	// 게시글 쓰기
	public int insert(Board board) throws Exception;
	
	// 게시글 읽기
	public Board read(int boardNo) throws Exception;
	
	// 게시글 수정
	public int update(Board board) throws Exception;
	
	// 게시글 삭제
	public int delete(int boardNo) throws Exception;

	// 검색
	public List<Board> list(String keyword) throws Exception;
	
	// [페이지] 게시글 목록
	public List<Board> list(Page page) throws Exception;
	
	// 게시글 개수
	public int count() throws Exception;
	
	// [검색][페이지] 게시글 목록
	public List<Board> list(Page page, String keyword) throws Exception;

	// [검색+옵션][페이지] 게시글 목록
	public List<Board> list(Page page, Option option)  throws Exception;
	
	
	
}





















