package com.csii.lipei.springbootProject.trigger;

import java.util.Date;
import java.util.concurrent.Future;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * 定时任务
 * @author lipei
 *
 */
@Component//指定class可以被springboot扫描
public class TestTask {
	
	@Autowired
	private AsyncTask asyncTask;
	
	//@Scheduled(fixedRate=2000)//定期执行任务,距离1启动或者上一次执行后的时间
	public void task(){
		System.out.println(new Date());
	}
	
	//@Scheduled(cron="0/10 * * * * ?")//固定时间或者时间间隔执行任务
	public void batch(){
		System.out.println("刘队喵喵喵");
	}
	
	//@Scheduled(cron="0/10 * * * * ?")//固定时间或者时间间隔执行任务
	public void asyTest() throws Exception{
		asyncTask.async1();
		asyncTask.async2();
		asyncTask.async3();
		Future<String> task4 = asyncTask.async4();
		for(;;){
			//isDone表示任务是否完成,isCancelled()是否取消
			if (task4.isDone()) {
				break;
			}
		}
		System.out.println(111);
	}
}
