package com.bit2015.mysite3.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bit2015.mysite3.dao.UserDao;
import com.bit2015.mysite3.vo.UserVo;

@Service
public class UserService {
	@Autowired
	UserDao userDao;
	//회원가입
	public void join( UserVo userVo){
		userDao.insert(userVo);
	}
	//로그인
	public UserVo login(UserVo userVo){
		UserVo vo = userDao.get(userVo.getEmail(), userVo.getPassword());
		return vo;
	}
	//수정시 비밀번호 확인
	public String get(UserVo userVo){
	String pass1 = (String)userDao.get(userVo.getNo());
	return pass1;
		
	}
	public void update(String password ,UserVo userVo){
		userDao.update(password , userVo.getNo());
	}
	//중복처리
	
	public UserVo getEmail(String email){
		UserVo vo = userDao.getEmail(email);
		return vo;
	}
}
