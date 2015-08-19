package com.bit2015.mysite3.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bit2015.mysite3.dao.UserDao;
import com.bit2015.mysite3.vo.UserVo;

@Service
public class UserService {
	@Autowired
	UserDao userDao;
	//ȸ������
	public void join( UserVo userVo){
		userDao.insert(userVo);
	}
	//�α���
	public UserVo login(UserVo userVo){
		UserVo vo = userDao.get(userVo.getEmail(), userVo.getPassword());
		return vo;
	}
	//������ ��й�ȣ Ȯ��
	public String get(UserVo userVo){
	String pass1 = (String)userDao.get(userVo.getNo());
	return pass1;
		
	}
	public void update(String password ,UserVo userVo){
		userDao.update(password , userVo.getNo());
	}
	//�ߺ�ó��
	
	public UserVo getEmail(String email){
		UserVo vo = userDao.getEmail(email);
		return vo;
	}
}
