package com.javaex.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaex.vo.UserVo;

@Repository
public class UserDao {
	
	@Autowired
	private SqlSession sqlSession;
	
	
	public void userInsert(UserVo userVo) {
		System.out.println("UserDao > userInsert()");
		sqlSession.insert("user.insert", userVo);
	}
	
	public UserVo getUser(UserVo userVo) {
		UserVo authVo = sqlSession.selectOne("user.login", userVo);
		return authVo;
	}
	
	public String idCheck(UserVo userVo) {
		String result = sqlSession.selectOne("user.idCheck", userVo);
		System.out.println("dao : " + result);
		return result;
		
	}
	
	
	
}
