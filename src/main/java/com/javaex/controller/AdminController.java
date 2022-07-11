package com.javaex.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.javaex.service.BlogService;
import com.javaex.service.CategoryService;
import com.javaex.vo.BlogVo;
import com.javaex.vo.CategoryVo;

@RequestMapping(value = "{id}/admin")
@Controller
public class AdminController {
	
	@Autowired
	private BlogService blogService;
	
	@Autowired
	private CategoryService categoryService;
	
	@RequestMapping(value = "basic", method = {RequestMethod.GET, RequestMethod.POST})
	public String basic(@PathVariable String id, Model model) {
		BlogVo blogVo = blogService.getInfo(id);
		model.addAttribute("blogVo", blogVo);
		return "blog/admin/blog-admin-basic";
	}
	
	@RequestMapping(value = "upload", method = {RequestMethod.GET, RequestMethod.POST})
	public String update(@RequestParam("blogTitle") String blogTitle,
						 @PathVariable String id,
						 @RequestParam("file") MultipartFile file) {
		
		BlogVo blogVo = new BlogVo();
		blogVo.setBlogTitle(blogTitle);
		blogService.update(blogVo, file);
		return "redirect:/" + blogVo.getId();
	}
	
	@RequestMapping(value = "category", method = {RequestMethod.GET, RequestMethod.POST})
	public String category(@PathVariable String id, Model model) {
		BlogVo blogVo = blogService.getInfo(id);
		model.addAttribute("blogVo", blogVo);
		return "blog/admin/blog-admin-cate";
	}
	
	@RequestMapping(value = "writeForm", method = {RequestMethod.GET, RequestMethod.POST})
	public String writeForm(@PathVariable String id, Model model) {
		BlogVo blogVo = blogService.getInfo(id);
		List<CategoryVo> cList = categoryService.getList(id);
		model.addAttribute("blogVo", blogVo);
		model.addAttribute("cList", cList);
		return "blog/admin/blog-admin-write";
	}
	
	@RequestMapping(value = "403", method = {RequestMethod.GET, RequestMethod.POST})
	public String error() {
		return "blog/error/403";
	}
	
}
