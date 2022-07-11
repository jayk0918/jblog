package com.javaex.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaex.dao.PostDao;
import com.javaex.vo.PostVo;

@Service
public class PostService {
	
	@Autowired
	private PostDao postDao;
	
	public int insert(PostVo postVo) {
		int count = postDao.insert(postVo);
		return count;
	}
	
	public List<PostVo> getList(int cateNo){
		return postDao.getList(cateNo);
	}
	
	public PostVo getPost(int postNo) {
		return postDao.getPost(postNo);
	}
	
	
}
