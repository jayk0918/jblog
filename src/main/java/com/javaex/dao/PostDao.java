package com.javaex.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaex.vo.PostVo;

@Repository
public class PostDao {
	
	@Autowired
	private SqlSession sqlSession;
	
	public int insert(PostVo postVo) {
		int count = sqlSession.insert("post.insert", postVo);
		return count;
	}
	
	public List<PostVo> getList(int cateNo){
		return sqlSession.selectList("post.getList", cateNo);
	}
	
	public PostVo getPost(int postNo) {
		return sqlSession.selectOne("post.getPost", postNo);
	}
	
	
}
