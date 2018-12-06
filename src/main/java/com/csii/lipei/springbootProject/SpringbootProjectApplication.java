package com.csii.lipei.springbootProject;


import javax.jms.ConnectionFactory;
import javax.jms.Queue;
import javax.jms.Topic;

import org.apache.activemq.command.ActiveMQQueue;
import org.apache.activemq.command.ActiveMQTopic;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.Bean;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.jms.config.JmsListenerContainerFactory;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;


@SpringBootApplication
@ServletComponentScan//servlet注解
@EnableScheduling//任务调度器
@EnableAsync//开启异步任务
@EnableJms//开启支持jms
//@MapperScan("com.csii.lipei.springbootTest.mapper")//扫描mybatis注解包
public class SpringbootProjectApplication {
	
	@Bean
	public Queue queue(){
		return new ActiveMQQueue("lipei-queue");
	}
	
	@Bean
	public Topic topic(){
		return new ActiveMQTopic("new.topic");
	}
	public static void main(String[] args) {
		SpringApplication.run(SpringbootProjectApplication.class, args);
	}
	
	/**
	 * 给topic定义独立的JmsListenerContainer
	 * @param activeMQ
	 * @return
	 */
	@Bean
	public JmsListenerContainerFactory<?> jmsListenerContainerTopic(ConnectionFactory activeMQ){
		DefaultJmsListenerContainerFactory bean = new DefaultJmsListenerContainerFactory();
		bean.setPubSubDomain(true);
		bean.setConnectionFactory(activeMQ);
		return bean;
	}
}
