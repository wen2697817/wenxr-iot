package com.wenxr.iot.common.action;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class TcpServer implements ServletContextListener {
	Thread thread;
	public void contextDestroyed(ServletContextEvent arg0) {
		thread.interrupt();
		if(thread.isInterrupted()) {
			System.out.println("线程关闭成功");
		}
	}

	public void contextInitialized(ServletContextEvent arg0) {
		thread = new Thread(new TCPProcess(8080));
		thread.start();
	}
}
