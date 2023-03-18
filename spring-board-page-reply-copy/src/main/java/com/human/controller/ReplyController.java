package com.human.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.human.domain.Reply;
import com.human.service.ReplyService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/reply")
public class ReplyController {
	
	@Autowired
	private ReplyService replyService;

	// 댓글 목록
	@GetMapping("/list")
	public String list(Model model, int boardNo) throws Exception {
		
		List<Reply> replyList = replyService.list(boardNo);
		model.addAttribute("replyList", replyList);
		return "/reply/list";
	}
	
	// 댓글 등록
	@PostMapping("/insert")
	public String insert(Model model, Reply reply) throws Exception {
		
		int result = replyService.insert(reply);
		
		if(result > 0) 			log.info("댓글 등록 성공...");
		else		 			log.info("댓글 등록 실패...");
		
		int boardNo = reply.getBoardNo();
		List<Reply> replyList = replyService.list(boardNo);
		model.addAttribute("replyList", replyList);
		
		return "/reply/list";
	}
	
	// 댓글 수정
	@PostMapping("/update")
	public String update(Model model, Reply reply) throws Exception {
		
		int result = replyService.update(reply);
		
		if(result > 0) 			log.info("댓글 수정 성공...");
		else		 			log.info("댓글 수정 실패...");
		
		int boardNo = reply.getBoardNo();
		List<Reply> replyList = replyService.list(boardNo);
		model.addAttribute("replyList", replyList);
		
		return "/reply/list";
	}
	
	
	// 댓글 삭제
	@PostMapping("/delete")
	public String delete(Model model, Reply reply) throws Exception {
		
		int replyNo = reply.getReplyNo();
		
		int result = replyService.delete(replyNo);
		
		if(result > 0) 			log.info("댓글 삭제 성공...");
		else		 			log.info("댓글 삭제 실패...");
		
		int boardNo = reply.getBoardNo();
		List<Reply> replyList = replyService.list(boardNo);
		model.addAttribute("replyList", replyList);
		
		return "/reply/list";
	}
	
	// 답글
	@PostMapping("/answer/insert")
	public String insertAnswer(Model model, Reply reply) throws Exception {
		
		// 답글 등록 요청
		int result = replyService.insertAnswer(reply);
		
		if(result > 0) 			log.info("답글 등록 성공...");
		else		 			log.info("답글 등록 실패...");
		
		// 댓글 목록 
		int boardNo = reply.getBoardNo();
		List<Reply> replyList = replyService.list(boardNo);
		model.addAttribute("replyList", replyList);
		
		return "/reply/list";
	}
	
	
	
}















