package com.javaex.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.javaex.service.UserService;

@Controller
@RequestMapping(value = "/api/user")
public class ApiUserController {
	
	@Autowired
	private UserService userService;
	
	@ResponseBody
	@RequestMapping(value = "idCheck", method = {RequestMethod.GET, RequestMethod.POST})
	public boolean idCheck(@RequestBody String id) {
		boolean result = userService.idCheck(id);
		System.out.println("controller : " + result);
		return result;
	}
	
	
}
