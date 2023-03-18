package com.human.domain;

import lombok.Data;

@Data
public class Option {
	
	String keyword;		// 검색어
	int optionCode;
	// 0 : 전체
	// 1 : 제목
	// 2 : 내용
	// 3 : 제목+내용
	// 4 : 작성자
	
	public Option() {
		this.keyword = "";
	}
	
	

}
