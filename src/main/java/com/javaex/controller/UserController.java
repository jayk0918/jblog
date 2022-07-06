package com.javaex.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.javaex.service.UserService;
import com.javaex.vo.UserVo;

@Controller
@RequestMapping(value="/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(value = "joinForm", method = {RequestMethod.GET, RequestMethod.POST})
	public String joinForm() {
		return "/user/joinForm";
	}
	
	@RequestMapping(value = "loginForm", method = {RequestMethod.GET, RequestMethod.POST})
	public String loginForm() {
		return "/user/loginForm";
	}
	
	@RequestMapping(value = "login", method = {RequestMethod.GET, RequestMethod.POST})
	public String login(@ModelAttribute UserVo userVo, HttpSession session) {
		System.out.println("UserController > login()");
		
		UserVo authUser = userService.login(userVo);
		
		if(authUser != null) {
			System.out.println("로그인 성공");
			session.setAttribute("authUser", authUser);
			return "redirect:/";
			
		}else {
			System.out.println("로그인 실패");
			return "redirect:/user/loginForm?result=fail";
		}
	}
	
	@RequestMapping(value = "join", method = {RequestMethod.GET, RequestMethod.POST})
	public String joinSuccess(@ModelAttribute UserVo userVo) {
		System.out.println("UserController>joinSuccess");
		userService.join(userVo);
		return "/user/joinSuccess";
	}
	
	@RequestMapping(value = "logout", method = {RequestMethod.GET, RequestMethod.POST})
	public String logout(HttpSession session) {
		System.out.println("로그아웃");
		session.removeAttribute("authUser");
		session.invalidate();
		return "redirect:/";
	}
	
}
