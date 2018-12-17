package com.csii.lipei.springbootProject.trigger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class TestTask3 {
	
	@Autowired
	private AsyncTask3 asyncTask3;
	
	@Scheduled(cron="0/10 * * * * *")
	public void test3(){
		asyncTask3.Async();
	}
}
