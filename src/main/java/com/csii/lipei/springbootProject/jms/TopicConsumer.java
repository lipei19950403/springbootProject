package com.csii.lipei.springbootProject.jms;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class TopicConsumer {
	
	@JmsListener(destination="new.topic",containerFactory="jmsListenerContainerTopic")
	public void receive2(String text){
		System.out.println("receive2" + text);
	}
	
	@JmsListener(destination="new.topic",containerFactory="jmsListenerContainerTopic")
	public void receive3(String text){
		System.out.println("receive3" + text);
	}
	
	@JmsListener(destination="new.topic",containerFactory="jmsListenerContainerTopic")
	public void receive4(String text){
		System.out.println("receive4" + text);
	}
	
}
