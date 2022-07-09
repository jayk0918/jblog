package com.javaex.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.javaex.service.PostService;
import com.javaex.vo.PostVo;

@RequestMapping(value = "{id}/admin/writeForm")
@Controller
public class PostController {
	
	@Autowired
	private PostService postService;
	
	@RequestMapping(value = "post", method = {RequestMethod.GET, RequestMethod.POST})
	public String post(	@RequestParam("cateNo") int cateNo,
						@RequestParam("postTitle") String postTitle,
						@RequestParam("postContent") String postContent,
						@PathVariable String id) {
		
		PostVo postVo = new PostVo();
		postVo.setCateNo(cateNo);
		postVo.setPostTitle(postTitle);
		postVo.setPostContent(postContent);
		
		postService.insert(postVo);
		
		return "redirect:/" + id;
	}
}
	
