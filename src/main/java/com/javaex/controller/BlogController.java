package com.javaex.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.javaex.service.BlogService;

@Controller
public class BlogController {
	@Autowired
	private BlogService blogService;
	
	@RequestMapping(value = "{id}" , method = {RequestMethod.GET, RequestMethod.POST})
	public String blogMain(@PathVariable String id, Model model) {
		Map<String, Object> blogInfoMap = blogService.getInfo(id);
		model.addAttribute("blogVo", blogInfoMap);
		
		return "blog/blog-main";
	}
	
	
	
}
