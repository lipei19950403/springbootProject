package com.csii.lipei.springbootProject.domain;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.csii.lipei.springbootProject.exception.BootException;

/**
 * 异常捕获类
 * @author lipei
 *
 */
@ControllerAdvice
public class CustomExtHandle {
		
	//捕获全局异常，处理所有不可知异常
	@ExceptionHandler(value=Exception.class)
	@ResponseBody
	Object handleException(Exception e,HttpServletRequest request){
		Map<String, Object> map = new HashMap<>();
		map.put("msg", e.getMessage());
		map.put("code", 103);
		map.put("url", request.getRequestURI());
		return map;
	}
	
	/**
	 * 自定义异常处理
	 * @param e
	 * @return
	 */
	@ExceptionHandler(value=BootException.class)
	@ResponseBody
	Object handleBootException(Exception e){
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("error.html");
		modelAndView.addObject("msg",e.getMessage());
		return modelAndView;
	}
	
	 
}
