package com.javaex.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaex.dao.BlogDao;
import com.javaex.dao.UserDao;
import com.javaex.vo.BlogVo;
import com.javaex.vo.UserVo;

@Service
public class UserService {
	
	@Autowired
	private UserDao userDao;
	
	@Autowired
	private BlogDao blogDao;
	
	public void join(UserVo userVo) {
		userDao.userInsert(userVo);
		
		BlogVo blogVo = new BlogVo();
		
		blogVo.setId(userVo.getId());
		blogVo.setBlogTitle(userVo.getUserName() + "의 블로그입니다.");
		blogVo.setLogoFile("/assets/images/spring-logo.jpg");
		
		System.out.println(blogVo);
		blogDao.createBlog(blogVo);
	}
	
	public UserVo login(UserVo userVo) {
		UserVo authUser = userDao.getUser(userVo);
		return authUser;
	}
	
	public boolean idCheck(String id) {
		UserVo userVo = new UserVo();
		userVo.setId(id);
		
		String result = userDao.idCheck(userVo);
		
		System.out.println("userservice : " + result);
		
		if(result != null) {
			return true;
		}else if(id == ""){
			return true;
		}else {
			return false;
		}
	}
	
}
