package com.javaex.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.javaex.service.CategoryService;
import com.javaex.vo.CategoryVo;

@Controller
@RequestMapping(value = "api/admin/category")
public class ApiCategoryController {
	
	@Autowired
	private CategoryService categoryService;
	
	@RequestMapping(value = "getList", method = {RequestMethod.GET, RequestMethod.POST})
	public List<CategoryVo> getList(@PathVariable String id) {
		return categoryService.getList();
		
	}
	
	
	
	
	
	
}
