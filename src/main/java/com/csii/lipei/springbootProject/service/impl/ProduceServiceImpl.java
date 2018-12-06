package com.csii.lipei.springbootProject.service.impl;

import javax.jms.Destination;
import javax.jms.Queue;
import javax.jms.Topic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.stereotype.Service;

import com.csii.lipei.springbootProject.service.ProduceService;
@Service
public class ProduceServiceImpl implements ProduceService {
	@Autowired(required=true)
	private JmsMessagingTemplate jmsMessagingTemplate;
	
	@Autowired
	private Queue queue;
	
	
	@Override
	public void sendMessage(Destination destination, String message) {
		jmsMessagingTemplate.convertAndSend(destination,message);
	}

	@Override
	public void sendMessage(String meaage) {
		jmsMessagingTemplate.convertAndSend(this.queue,meaage);
	}
	
	
	
	//=========发布订阅相关代码===========
	
	@Autowired
	private Topic topic;
	@Override
	public void publish(String msg) {
		this.jmsMessagingTemplate.convertAndSend(this.topic,msg);
	}

}
