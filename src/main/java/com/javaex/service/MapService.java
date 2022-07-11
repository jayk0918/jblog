package com.javaex.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaex.dao.BlogDao;
import com.javaex.dao.CategoryDao;

@Service
public class MapService {
	
	@Autowired
	private BlogDao blogDao;
	
	@Autowired
	private CategoryDao categoryDao;
	
	public Map<String, Object> blogMap(String id){
		Map<String, Object> blogMap = new HashMap<>();
		
		Map<String, Object> blogInfo = new HashMap<>();
		blogInfo.put("blogInfo", blogDao.getInfo(id));
		
		Map<String, Object> cateInfo = new HashMap<>();
		cateInfo.put("cateInfo", categoryDao.getList(id));
		
		
		blogMap.put("blogInfo", blogInfo);
		blogMap.put("cateInfo", cateInfo);
		
		return blogMap;
	}
	
	
	
	
}
