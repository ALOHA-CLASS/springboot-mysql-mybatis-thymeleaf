package com.human.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.human.domain.Board;
import com.human.domain.Option;
import com.human.domain.Page;

@Mapper
public interface BoardMapper {
	
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
	public List<Board> search(String keyword) throws Exception;
	
	// [페이지] 게시글 목록
	public List<Board> page(Page page) throws Exception;
	
	// 게시글 개수
	public int count() throws Exception;
	
	// [검색][페이지] 게시글 모록
	public List<Board> boardList(@Param("page") Page page, @Param("option") Option option) throws Exception;
	
	// [검색] 게시글 개수
	public int countWithKeyword(@Param("option") Option option) throws Exception;
	
}


















