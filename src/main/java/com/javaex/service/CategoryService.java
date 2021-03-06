package com.javaex.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaex.dao.CategoryDao;
import com.javaex.vo.CategoryVo;

@Service
public class CategoryService {
	
	@Autowired
	private CategoryDao categoryDao;
	
	public List<CategoryVo> getList(String id){
		
		return categoryDao.getList(id);
	}
	
	public void addList(CategoryVo categoryVo) {
		categoryDao.addList(categoryVo);
	}
	
	public String delete(CategoryVo categoryVo) {
		int count = categoryDao.delete(categoryVo);
		String status;
		
		if(count >0) {
			status = "success";
		}else {
			status = "fail";
		}
		
		return status;
	}
	
	
	
}
