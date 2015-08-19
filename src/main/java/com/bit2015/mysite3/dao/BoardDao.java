package com.bit2015.mysite3.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.ibatis.SqlMapClientTemplate;
import org.springframework.stereotype.Repository;

import com.bit2015.mysite3.vo.BoardVo;

@Repository
public class BoardDao {
	@Autowired
	SqlMapClientTemplate sqlMapClientTemplate;
	
	public List<BoardVo> getList(long page){
		List<BoardVo> list = sqlMapClientTemplate.queryForList("board.pagingGetList", page);
		return list;
	}
	public BoardVo getView(long no){
		BoardVo vo = (BoardVo)sqlMapClientTemplate.queryForObject("board.getView", no);
		return vo;
	}
	public void insert(BoardVo vo){
		sqlMapClientTemplate.insert("board.insert", vo);
	}
	public void hit(long no){
		sqlMapClientTemplate.update("board.hit", no);
	}
	public void delete(long no , long user_no){
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("no", no);
		map.put("user_no", user_no);
		sqlMapClientTemplate.delete("board.delete",map);
	}
	public void modify(String title, String message, long hit, long no, long user_no){
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("title", title);
		map.put("message", message);
		map.put("hit", hit);
		map.put("no", no);
		map.put("user_no", user_no);
		sqlMapClientTemplate.update("board.modify", map);
	}
	public List<BoardVo> search(String title, long page){
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("title", title);
		map.put("page", page);
		List<BoardVo> list =sqlMapClientTemplate.queryForList("board.search", map);
		
		return list;
	}
}
