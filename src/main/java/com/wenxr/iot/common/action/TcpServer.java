package com.wenxr.iot.common.action;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class TcpServer implements ServletContextListener {
	Thread thread;
	public void contextDestroyed(ServletContextEvent arg0) {
//		final Set<Thread> threads = Thread.getAllStackTraces().keySet(); 
//		System.out.println(threads.size());
//		 for (Thread thread1 : threads) { 
//			 if(!thread1.isInterrupted()) {
//				 thread1.interrupt();
//				 if(thread1.isInterrupted()) {
//					 System.out.println("线程"+thread1.getName()+"关闭成功");
//				 }
//			 }
//		 }
		if(thread.isInterrupted()) {
			System.out.println("线程关闭成功");
		}
	}

	public void contextInitialized(ServletContextEvent arg0) {
		thread = new Thread(new TCPProcess(8080));
		thread.setDaemon(true);
		thread.start();
	}
}
