package com.javaex.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@RequestMapping(value = "{id}/admin/writeForm")
@Controller
public class PostController {
	
	
	@RequestMapping(value = "post", method = {RequestMethod.GET, RequestMethod.POST})
	public String post(@PathVariable String id) {
		return "redirect:/" + id;
	}
	
	
	
	
	
	
	
}
