package com.csii.lipei.springbootProject.trigger;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
@Component
public class AsyncTask3 {
	
	@Async
	public void Async(){
		System.out.println(1);
	}
}
