package com.csii.lipei.springbootProject.controller;

import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.csii.lipei.springbootProject.domain.User;

/**
 * json测试
 * @author lipei
 *
 */
@Controller
public class JacksonController {
	
	@ResponseBody
	@RequestMapping("/test/jackson")
	public Object getJson(){
		
		return new User("11","11","22",new Date());
	}
	

}
