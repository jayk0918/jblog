package com.javaex.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaex.dao.UserDao;
import com.javaex.vo.UserVo;

@Service
public class UserService {
	
	@Autowired
	private UserDao userDao;
	
	public void join(UserVo userVo) {
		userDao.userInsert(userVo);
	}
	
	public UserVo login(UserVo userVo) {
		UserVo authUser = userDao.getUser(userVo);
		return authUser;
	}
}
