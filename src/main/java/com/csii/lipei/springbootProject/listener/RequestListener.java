package com.csii.lipei.springbootProject.listener;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;
@WebListener//监听器注解
public class RequestListener implements ServletRequestListener {

	@Override
	public void requestDestroyed(ServletRequestEvent sre) {
		System.out.println("requestDestroyed");
	}

	@Override
	public void requestInitialized(ServletRequestEvent sre) {
		System.out.println("requestInitialized");
	}
	
}
