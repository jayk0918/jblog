package com.javaex.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.javaex.service.CategoryService;
import com.javaex.vo.CategoryVo;

@Controller
@RequestMapping(value = "{id}/admin/api/category")
public class ApiCategoryController {
	
	@Autowired
	private CategoryService categoryService;
	
	@ResponseBody
	@RequestMapping(value = "getList", method = {RequestMethod.GET, RequestMethod.POST})
	public List<CategoryVo> getList(@PathVariable String id) {
		List<CategoryVo> list = categoryService.getList(id);
		System.out.println(list);
		return list;
	}
	
	@ResponseBody
	@RequestMapping(value = "addList", method = {RequestMethod.GET, RequestMethod.POST})
	public CategoryVo addList(@ModelAttribute CategoryVo categoryVo) {
		System.out.println(categoryVo);
		categoryService.addList(categoryVo);
		return categoryVo;
	}
	
	@ResponseBody
	@RequestMapping(value = "delete", method = {RequestMethod.GET, RequestMethod.POST})
	public String delete(@ModelAttribute CategoryVo categoryVo) {
		String status = categoryService.delete(categoryVo);
		return status;
	}
	
	
	
	
}
