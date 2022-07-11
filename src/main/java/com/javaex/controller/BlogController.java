package com.javaex.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.javaex.service.BlogService;
import com.javaex.service.CategoryService;
import com.javaex.service.PostService;
import com.javaex.vo.BlogVo;
import com.javaex.vo.CategoryVo;
import com.javaex.vo.PostVo;

@Controller
public class BlogController {
	@Autowired
	private BlogService blogService;
	
	@Autowired
	private CategoryService categoryService;
	
	@Autowired
	private PostService postService;
	
	@RequestMapping(value = "{id}" , method = {RequestMethod.GET, RequestMethod.POST})
	public String blogMain(	@PathVariable String id, Model model,
							@RequestParam(value="cateNo", required=false, defaultValue="0") int cateNo,
							@RequestParam(value="postNo", required=false, defaultValue="0") int postNo) {
		BlogVo blogVo = blogService.getInfo(id);
		PostVo postVo = postService.getPost(postNo);
		List<CategoryVo> cList = categoryService.getList(id);
		List<PostVo> pList = postService.getList(cateNo);
		
		
		model.addAttribute("blogVo", blogVo);
		model.addAttribute("cList", cList);
		model.addAttribute("pList", pList);
		model.addAttribute("postVo", postVo);
		
		return "blog/blog-main";
	}
	
	
	
}
