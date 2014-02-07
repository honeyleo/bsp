package com.bsp.utils;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;


/**
 * 异步任务控制
 * 
 * @author Kevin Jiang
 */
public class TaskController {
	
	private static final ExecutorService exe = Executors.newCachedThreadPool(new ThreadFactory() {
		@Override
		public Thread newThread(Runnable r) {
			Thread t = new Thread(r);
			t.setDaemon(true);
			return t;
		}
	});
	
//	private static final ExecutorService exe = Executors.newCachedThreadPool();
	
	/**
	 * 创建异步任务并执行
	 * @param task
	 */
	public static void createTaskAndRun(Task task) {
		exe.execute(task);
	}
	
	public interface Task extends Runnable {
		
		@Override
		public void run();
		
	}

}
