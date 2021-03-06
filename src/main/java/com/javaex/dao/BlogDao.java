package com.javaex.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaex.vo.BlogVo;

@Repository
public class BlogDao {
	
	@Autowired
	private SqlSession sqlSession;
	
	public void createBlog(BlogVo blogVo) {
		System.out.println("dao : " + blogVo);
		sqlSession.insert("blog.create", blogVo);
	}
	
	public BlogVo getInfo(String id) {
		return sqlSession.selectOne("blog.getInfo", id);
	}
	
	public void update(BlogVo blogVo) {
		sqlSession.update("blog.update", blogVo);
	}
	
	
}
