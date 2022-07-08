package com.javaex.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.javaex.service.BlogService;
import com.javaex.vo.BlogVo;

@Controller
public class AdminController {
	
	@Autowired
	private BlogService blogService;
	
	
	@RequestMapping(value = "{id}/admin/basic", method = {RequestMethod.GET, RequestMethod.POST})
	public String basic(@PathVariable String id, Model model) {
		BlogVo blogVo = blogService.getInfo(id);
		model.addAttribute("blogVo", blogVo);
		return "blog/admin/blog-admin-basic";
	}
	
	@RequestMapping(value = "{id}/admin/update", method = {RequestMethod.GET, RequestMethod.POST})
	public String update(@ModelAttribute BlogVo blogVo, @PathVariable String id){
		
		System.out.println("contoller : " + blogVo);
		blogService.update(blogVo);
		
		return "redirect:/";
	}
	
	@RequestMapping(value = "{id}/admin/category", method = {RequestMethod.GET, RequestMethod.POST})
	public String category(@PathVariable String id, Model model) {
		BlogVo blogVo = blogService.getInfo(id);
		model.addAttribute("blogVo", blogVo);
		return "blog/admin/blog-admin-cate";
	}
	
	@RequestMapping(value = "{id}/admin/writeForm", method = {RequestMethod.GET, RequestMethod.POST})
	public String writeForm(@PathVariable String id, Model model) {
		BlogVo blogVo = blogService.getInfo(id);
		model.addAttribute("blogVo", blogVo);
		return "blog/admin/blog-admin-write";
	}
	
	@RequestMapping(value = "403", method = {RequestMethod.GET, RequestMethod.POST})
	public String error() {
		return "blog/error/403";
	}
	
}
