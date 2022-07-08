package com.javaex.api.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "{id}/api/admin/category")
public class ApiCategoryController {
	
	@RequestMapping(value = "getList", method = {RequestMethod.GET, RequestMethod.POST})
	public String getList() {
		
		
		
		return "";
	}
	
	
	
	
	
	
}
