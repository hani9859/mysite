package com.bit2015.mysite3.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.ibatis.SqlMapClientTemplate;
import org.springframework.stereotype.Repository;

import com.bit2015.mysite3.vo.ReplyVo;

@Repository
public class ReplyDao {
	@Autowired
	SqlMapClientTemplate sqlMapClientTemplate;
	
	public List<ReplyVo> getList(long board_no){
		List<ReplyVo> list = sqlMapClientTemplate.queryForList("board.replyList", board_no);
		return list;
	}
	public void insert(long board_no, long user_no, String name, String message, long order_no, long depth){
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("board_no", board_no);
		map.put("user_no", user_no);
		map.put("name", name);
		map.put("message", message);
		map.put("order_no", order_no);
		map.put("depth", depth);
		
		sqlMapClientTemplate.insert("board.addReply", map);
	}
	public void insert(long board_no, long user_no, String name, String message, long group_no ,long order_no, long depth){
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("board_no", board_no);
		map.put("user_no", user_no);
		map.put("name", name);
		map.put("message", message);
		map.put("group_no", group_no);
		map.put("order_no", order_no);
		map.put("depth", depth);
		
		sqlMapClientTemplate.insert("board.reReply", map);
	}
	public void update(long group_no, long order_no){
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("group_no", group_no);
		map.put("order_no", order_no);
		
		sqlMapClientTemplate.update("board.update", map);
	}
	public void delete(long board_no, long group_no, long order_no){
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("board_no", board_no);
		map.put("group_no", group_no);
		map.put("order_no", order_no);
		sqlMapClientTemplate.delete("board.replydelete", map);
	}
}
