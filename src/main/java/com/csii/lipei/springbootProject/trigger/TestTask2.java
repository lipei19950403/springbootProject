package com.csii.lipei.springbootProject.trigger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class TestTask2 {
	
	@Autowired
	private AsyncTask2 asy;
	
	//@Scheduled(cron="*/10 * * * * ?")
	public void batch() throws Exception{
		asy.task1();
		asy.task2();
		asy.task3();
		System.out.println(111);
	}
}
