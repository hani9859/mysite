package com.bit2015.mysite3.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.ibatis.SqlMapClientTemplate;
import org.springframework.stereotype.Repository;

import com.bit2015.mysite3.vo.GuestBookVo;

@Repository
public class GuestBookDao {
	@Autowired
	SqlMapClientTemplate sqlMapClientTemplate;
	
	public List<GuestBookVo> getList(){
		List<GuestBookVo> list = sqlMapClientTemplate.queryForList("guestbook.list");
		
		return list;
	}
	public void insert(GuestBookVo vo) {
		sqlMapClientTemplate.insert("guestbook.insert", vo);
	}
	public void delete(long no){
		sqlMapClientTemplate.delete("guestbook.delete", no);
	}
	
}
