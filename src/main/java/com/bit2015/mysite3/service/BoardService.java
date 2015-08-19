package com.bit2015.mysite3.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bit2015.mysite3.dao.BoardDao;
import com.bit2015.mysite3.dao.ReplyDao;
import com.bit2015.mysite3.vo.BoardVo;
import com.bit2015.mysite3.vo.ReplyVo;

@Service
public class BoardService {
	@Autowired
	BoardDao boardDao;
	@Autowired
	ReplyDao replyDao;
	
	public List<BoardVo> getList(long page){
		List<BoardVo> list =boardDao.getList(page);
		return list;
	}
	public BoardVo getView(long no){
		BoardVo vo = boardDao.getView(no);
		return vo;
	}
	public void insert(BoardVo vo){
		boardDao.insert(vo);
	}
	public void hit(long no){
		boardDao.hit(no);
	}
	public void delete(long no, long user_no){
		boardDao.delete(no, user_no);
	}
	public void modify(String title, String message, long hit, long no, long user_no){
		boardDao.modify(title, message, hit, no, user_no);
	}
	public List<BoardVo> search(String title, long page){
		List<BoardVo> list = boardDao.search(title,page);
		return list;
	}
	public List<ReplyVo> replyList(long board_no){
		List<ReplyVo> list = replyDao.getList(board_no);
		return list;
	}
	public void insert(long board_no, long user_no, String name, String message,long order_no, long depth){
		replyDao.insert(board_no, user_no, name, message, order_no, depth);
	}
	public void insert(long board_no, long user_no, String name, String message, long group_no,long order_no, long depth){
		replyDao.update(group_no, order_no);
		long order = order_no+1;
		long depth1 = depth +1;
		replyDao.insert(board_no, user_no, name, message, group_no, order, depth1);
	}
	public void replyDelete(long board_no, long group_no, long order_no){
		replyDao.delete(board_no, group_no, order_no);
	}
}
