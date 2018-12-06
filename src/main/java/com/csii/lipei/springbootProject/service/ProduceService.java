package com.csii.lipei.springbootProject.service;

import javax.jms.Destination;

/**
 * 消息生产
 * @author lipei
 *
 */
public interface ProduceService {
	/**
	 * 指定消息队列，还有消息
	 * @param destination
	 * @param message
	 */
	public void sendMessage(Destination destination,final String message);
	
	/**
	 * 使用默认队列，发送消息
	 * @param meaage
	 */
	public void sendMessage(final String meaage);
	
	/**
	 * 消息发布者
	 */
	public void publish(String msg);
	
}
