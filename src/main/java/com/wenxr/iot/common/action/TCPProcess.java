package com.wenxr.iot.common.action;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPProcess implements Runnable{
	ServerSocket serverSocket = null;
	public TCPProcess(final int port) {
		try {
			serverSocket = new ServerSocket(port);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void run() {
		// TODO Auto-generated method stub
		Socket socket = null;
		try {
			// 建立服务器的Socket，并设定一个监听的端口PORT
			// 由于需要进行循环监听，因此获取消息的操作应放在一个while大循环中
			while (true) {
				try {
					if(serverSocket==null) {
						return;
					}
					// 建立跟客户端的连接
					socket = serverSocket.accept();
				} catch (Exception e) {
					System.out.println("建立与客户端的连接出现异常");
					//e.printStackTrace();
				}
				ServerThread thread = new ServerThread(socket);
				thread.setDaemon(true);
				thread.start();
			}
		} catch (Exception e) {
			System.out.println("端口被占用");
			e.printStackTrace();
		} finally {
			try {
				if(serverSocket!=null) {
					serverSocket.close();
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
