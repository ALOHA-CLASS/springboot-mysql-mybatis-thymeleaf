package com.human.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.human.domain.Reply;
import com.human.mapper.ReplyMapper;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class ReplyServiceImpl implements ReplyService {
	
	@Autowired
	private ReplyMapper replyMapper;

	@Override
	public List<Reply> list() throws Exception {
		List<Reply> replyList = replyMapper.list();
		
		
		for (Reply reply : replyList) {
			log.info(reply.toString());
		}
		
		
		return replyList;
	}

	@Override
	public List<Reply> list(int boardNo) throws Exception {
		List<Reply> replyList = replyMapper.listByBoardNo(boardNo);
		return replyList;
	}

	@Override
	public int insert(Reply reply) throws Exception {
		
		int result = replyMapper.insert(reply);
		
		// 댓글 번호 최댓값
		int replyNo = replyMapper.maxReplyNo();
		log.info("replyNo : " + replyNo);
		reply.setReplyNo(replyNo);
		reply.setGroupNo(replyNo);
		
		result = replyMapper.update(reply);
		
		
		return result;
	}

	@Override
	public int update(Reply reply) throws Exception {
		int result = replyMapper.update(reply);
		return result;
	}

	@Override
	public int delete(int replyNo) throws Exception {
		int result = 0;
		
		// 삭제할 댓글 정보 조회
		Reply reply = replyMapper.select(replyNo);
		
		int subCount = reply.getSubCount();
		
		// 자식 댓글이 없으면, 삭제
		if( subCount == 0 ) {
			// 삭제요청
			result = replyMapper.delete(replyNo);
		}
		// 자식 댓글이 있으면, "삭제된 게시글 입니다" 로 내용 수정
		else {
			reply.setWriter("---");
			reply.setContent("삭제된 게시글 입니다");
			result = replyMapper.update(reply);
			return result;
		}
		
		// 댓글 삭제시, 부모댓글의 자식 개수 - 1 
		int parentNo = reply.getParentNo();
		syncSubCount(parentNo, -1);
		
		return result;
	}

	@Override
	public int insertAnswer(Reply reply) throws Exception {
		
		// 계층번호 + 1
		int depthNo = reply.getDepthNo() + 1;
		// 순서번호  = 부모 댓글의 순서번호 + 부모 댓글의 자식개수 + 1
		int seqNo = reply.getSeqNo() + reply.getSubCount() + 1;
		
		reply.setDepthNo(depthNo);
		reply.setSeqNo(seqNo);
		
		// 뒤의 순서번호 + 1
		replyMapper.syncSeqNo(reply);
		
		// 답글 등록
		int result = replyMapper.insert(reply);
		
		// 부모글의 자식 개수 + 1
		int parentNo = reply.getParentNo();
		syncSubCount(parentNo, 1);
		
		
		return result;
	}
	
	// 5
	// 	10
	// 		12
	// 			14
	// 부모 댓글의 자식 개수 갱신
	public void syncSubCount(int parentNo, int no) throws Exception {
		
		// 부모 정보 조회
		Reply reply = replyMapper.select(parentNo);
		
		if( reply == null ) return;
		
		// 조상 번호
		int ancestorNo = reply.getParentNo();
		
		// 부모 댓글 자식개수 갱신
		replyMapper.syncSubCount(parentNo, no);

		// (종료조건) 원본 댓글에서 멈춤
		if( ancestorNo == 0 ) return;
		
		// 재귀 호출
		syncSubCount(ancestorNo, no);
		
	}

}




















