package com.bit2015.mysite3.dao;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.ibatis.SqlMapClientTemplate;
import org.springframework.stereotype.Repository;

import com.bit2015.mysite3.vo.UserVo;

@Repository
public class UserDao {
	@Autowired
	SqlMapClientTemplate sqlMapClientTemplate;
	
	public UserVo get(String email, String password) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("email", email);
		map.put("password", password);
		
		UserVo vo =(UserVo)sqlMapClientTemplate.queryForObject("user.getByEmailAndPassword", map);
		
		return vo;
	}
	public void insert(UserVo vo) {
		sqlMapClientTemplate.insert("user.insert", vo);
	}
	public String get(long no){
		  String pass = (String)sqlMapClientTemplate.queryForObject("user.getPassword", no);
		  return pass;
	}
	public void update(String password ,long no){
		Map<String, Object > map = new HashMap<String, Object>();
		map.put("password", password);
		map.put("no", no);
		
		sqlMapClientTemplate.update("user.update", map);
		
	}
	public UserVo getEmail(String email){
		UserVo vo =(UserVo) sqlMapClientTemplate.queryForObject("user.getEmail", email);
		return vo;
	}
}
