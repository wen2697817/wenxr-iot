package com.wenxr.iot.common.action;


import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class TcpServer implements ServletContextListener {
	
	public void contextDestroyed(ServletContextEvent arg0) {
		
	}
	public void contextInitialized(ServletContextEvent arg0) {
		 new Thread(new TCPProcess(8088)).start();
	}
}
