package com.csii.lipei.springbootProject.trigger;

import java.util.concurrent.Future;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Component;

@Component
public class AsyncTask2 {
	private Logger logger =  LoggerFactory.getLogger(this.getClass());
	
	@Async
	public void task1() throws Exception{
		long begin = System.currentTimeMillis();
		Thread.sleep(1000);
		long end = System.currentTimeMillis();
		System.out.println("任务1执行时间为"+(end - begin));
	}
	
	@Async
	public void task2() throws Exception{
		long begin = System.currentTimeMillis();
		Thread.sleep(2000);
		long end = System.currentTimeMillis();
		System.out.println("任务2执行时间为"+(end - begin)); 
	}
	
	@Async
	public void task3() throws Exception{
		long begin = System.currentTimeMillis();
		Thread.sleep(3000);
		long end = System.currentTimeMillis();
		System.out.println("任务3执行时间为"+(end - begin));
	}
	
	@Async
	public Future<String> task4() throws Exception{
		Thread.sleep(2000);
		return new AsyncResult<String>("22");
	}
}
