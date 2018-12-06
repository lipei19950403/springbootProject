package com.csii.lipei.springbootProject.controller;

import javax.jms.Destination;

import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.csii.lipei.springbootProject.service.ProduceService;
@Controller
@RequestMapping("/api/v3")
public class OrderController {
	 
	@Autowired
	private ProduceService produceService;
	
	@ResponseBody
	@GetMapping("order")
	public Object order(String msg){
		Destination destination = new ActiveMQQueue("lipei-queue");
		produceService.sendMessage(destination, msg);
		return "123";
	}
	
	public Object common(String msg){
		produceService.sendMessage(msg);
		return "123";
	}
	
	/**
	 * 发布消息，生产者
	 * @param msg
	 * @return
	 */
	@ResponseBody
	@GetMapping("topic")
	public Object topic(String msg){
		produceService.publish(msg);
		return "123";
	}
}
