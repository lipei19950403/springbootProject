package com.csii.lipei.springbootProject.jms;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class OrderConsumer {
	
	@JmsListener(destination="lipei-queue")
	public void receiveQueue(String text){
		System.out.println("receiveQueue" + text);
	}
}
