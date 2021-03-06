package com.javaex.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaex.vo.CategoryVo;

@Repository
public class CategoryDao {
	
	@Autowired
	private SqlSession sqlSession;
	
	public List<CategoryVo> getList(String id) {
		return sqlSession.selectList("category.getList", id);
	}
	
	public void addList(CategoryVo categoryVo) {
		sqlSession.insert("category.insert", categoryVo);
	}
	
	public int delete(CategoryVo categoryVo) {
		return sqlSession.delete("category.delete", categoryVo);
	}
	
	
}
