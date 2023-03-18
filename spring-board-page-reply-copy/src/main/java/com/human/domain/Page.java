package com.human.domain;

import lombok.Data;

@Data
public class Page {
	
	private static final int PAGE_NUM = 1;			// 현재 페이지 기본값
	private static final int ROWS_PER_PAGE = 10;	// 페이지당 개수 기본값
	private static final int PAGE_COUNT = 10;		// 노출 페이지 개수 기본값
	
	private int pageNum;			// 현재 페이지 번호
	private int rowsPerPage;		// 페이지 당 게시물 수
	private int pageCount;			// 노출 페이지 개수
	private int totalCount;			// 전체 데이터 개수
	
	private int startPage;			// 시작 페이지 번호
	private int endPage;			// 끝 페이지 번호
	
	private int firstPage;			// 첫 페이지 번호
	private int lastPage;			// 마지막 페이지 번호
	
	private int prev;				// 이전 페이지 번호
	private int next;				// 다음 페이지 번호
	
	private int index;				// 시작 데이터 index
	
	// 생성자
	public Page() {
		this( PAGE_NUM, ROWS_PER_PAGE, PAGE_COUNT, 0 ); 
	}
	
	public Page(int totalCount) {
		this( PAGE_NUM, ROWS_PER_PAGE, PAGE_COUNT, totalCount ); 
	}
	
	public Page(int pageNum, int totalCount) {
		this( pageNum, ROWS_PER_PAGE, PAGE_COUNT, totalCount ); 
	}
	
	public Page(int pageNum, int rowsPerPage, int pageCount, int totalCount) {
		this.pageNum = pageNum;
		this.rowsPerPage = rowsPerPage;
		this.pageCount = pageCount;
		this.totalCount = totalCount;

		// 이전, 다음
		this.prev = pageNum - 1;
		this.next = pageNum + 1;
		
		// 시작, 끝
		// 시작 : ((현재 페이지 번호-1) / 노출 페이지 개수) * 노출 페이지 개수 + 1
		this.startPage = ((pageNum-1) / pageCount) * pageCount + 1;
		
		// 끝  : (((현재 페이지 번호-1) / 노출 페이지 개수 + 1)) * 노출 페이지 개수
		this.endPage = (((pageNum-1) / pageCount) +1 ) * pageCount;
		
		// 첫, 마지막
		this.firstPage = 1;
		
		// 마지막 : (전체 데이터 개수-1) / 페이지당 게시물 수 + 1
		this.lastPage = (totalCount-1) / rowsPerPage + 1;

		// 끝 페이지가 마지막 페이지보다 클때, 
		// 실데 데이터 개수를 반영한 끝페이지로 보정
		if( this.endPage > this.lastPage ) {
			this.endPage = this.lastPage;
		}
		
		// 시작 index
		this.index = (this.pageNum - 1) * this.rowsPerPage;
		
	}
	
	
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
		// totalCount 변경 시, lastPage 다시 계산
		this.lastPage = (totalCount-1) / rowsPerPage + 1;
	}
	
	
	// 페이징 처리 계산
	public void calc(Page page) {
		
		int pageNum = page.getPageNum();
		int rowsPerPage = page.getRowsPerPage();
		int pageCount = page.getPageCount();
		int totalCount = page.getTotalCount();
		
		// 이전, 다음
		this.prev = pageNum - 1;
		this.next = pageNum + 1;
		
		// 시작, 끝
		// 시작 : ((현재 페이지 번호-1) / 노출 페이지 개수) * 노출 페이지 개수 + 1
		this.startPage = ((pageNum-1) / pageCount) * pageCount + 1;
		
		// 끝  : (((현재 페이지 번호-1) / 노출 페이지 개수 + 1)) * 노출 페이지 개수
		this.endPage = (((pageNum-1) / pageCount) +1 ) * pageCount;
		
		// 첫, 마지막
		this.firstPage = 1;
		
		// 마지막 : (전체 데이터 개수-1) / 페이지당 게시물 수 + 1
		this.lastPage = (totalCount-1) / rowsPerPage + 1;

		// 끝 페이지가 마지막 페이지보다 클때, 
		// 실데 데이터 개수를 반영한 끝페이지로 보정
		if( this.endPage > this.lastPage ) {
			this.endPage = this.lastPage;
		}
		
		// 시작 index
		this.index = (this.pageNum - 1) * this.rowsPerPage;
		
	}
	
	
	
	
	

}











