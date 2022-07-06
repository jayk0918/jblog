package com.javaex.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.javaex.service.UserService;

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
	public String login() {
		return "redirect:/";
	}
	
	@RequestMapping(value = "joinSuccess", method = {RequestMethod.GET, RequestMethod.POST})
	public String joinSuccess() {
		return "/user/joinSuccess";
	}
	
}
