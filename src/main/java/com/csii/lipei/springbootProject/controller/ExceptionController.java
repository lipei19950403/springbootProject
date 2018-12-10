package com.csii.lipei.springbootProject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ExceptionController {
	
	@ResponseBody
	@RequestMapping("/text/exception")
	public Object index(){
		
		return "index";
	}
}
