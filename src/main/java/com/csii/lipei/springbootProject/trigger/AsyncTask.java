package com.csii.lipei.springbootProject.trigger;

import java.util.concurrent.Future;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Component;

/**
 * 异步处理业务类
 * @author lipei
 *
 */
@Component
public class AsyncTask {
	
	private Logger logger =  LoggerFactory.getLogger(this.getClass());
	
	@Async//给方法标注代表方法为异步，给类标注代表类的方法都为异步
	public void async1() throws InterruptedException{
		long begin = System.currentTimeMillis();
		Thread.sleep(1000);
		long end = System.currentTimeMillis();
		System.out.println("任务1耗时"+ (end -begin));
	}
	@Async
	public void async2() throws InterruptedException{
		long begin = System.currentTimeMillis();
		Thread.sleep(2000);
		long end = System.currentTimeMillis();
		System.out.println("任务2耗时"+ (end -begin));
	}
	
	@Async
	public void async3() throws InterruptedException{
		long begin = System.currentTimeMillis();
		Thread.sleep(3000);
		long end = System.currentTimeMillis();
		System.out.println("任务3耗时"+ (end -begin));
	}
	
	@Async
	public Future<String> async4() throws Exception{
		long begin = System.currentTimeMillis();
		Thread.sleep(2000);
		long end = System.currentTimeMillis();
		return new AsyncResult<String>("任务4执行结束");
	}
}
