package com.javaex.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaex.dao.BlogDao;
import com.javaex.vo.BlogVo;

@Service
public class BlogService {
	
	@Autowired
	private BlogDao blogDao;
	
	public BlogVo getInfo(String id) {
		return blogDao.getInfo(id);
	}
	
	public void update(BlogVo blogVo) {
		
		if(blogVo.getBlogTitle() == null) {
			String id = blogVo.getId();
			BlogVo oldData = blogDao.getInfo(id);
			String oldtitle = oldData.getBlogTitle();
			blogVo.setBlogTitle(oldtitle);
			blogDao.update(blogVo);
			
		}else if(blogVo.getLogoFile() == null){
			String id = blogVo.getId();
			BlogVo oldData = blogDao.getInfo(id);
			String oldLogoFile = oldData.getLogoFile();
			blogVo.setLogoFile(oldLogoFile);
			blogDao.update(blogVo);
		}else {
			blogDao.update(blogVo);
		}
		System.out.println("update : " + blogVo);
	}
	
	
	
	
	
}
