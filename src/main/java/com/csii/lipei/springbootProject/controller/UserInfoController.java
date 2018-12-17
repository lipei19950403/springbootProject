package com.csii.lipei.springbootProject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.csii.lipei.springbootProject.service.UserInfoService;

@Controller
public class UserInfoController {
	@Autowired
	private UserInfoService userInfoService;
	
	
	@ResponseBody
	@GetMapping("/test/queryUser")
	public Object queryUser(){
		return userInfoService.queryUser();
	}
}
