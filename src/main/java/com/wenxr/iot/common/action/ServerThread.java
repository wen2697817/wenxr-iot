package com.wenxr.iot.common.action;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class ServerThread extends Thread {
	private Socket socket;
	InputStream inputStream;
	OutputStream outputStream;

	public ServerThread(Socket socket) {
		this.socket = socket;
	}

	public void run() {
		try {
			while (true) {
				// 接收客户端的消息并打印
				System.out.println(socket);
				inputStream = socket.getInputStream();
				byte[] bytes = new byte[1024];
				inputStream.read(bytes);
				String string = new String(bytes);
				string =string.trim();//去除首尾空格
				String s = string.substring(0, 1);//判断是否已{开始
				int e = string.lastIndexOf("}");
				int l = string.length();//判断是否已}结束
				if(s.equals("{")&&e==l-1) {
					String ipConfig = String.valueOf(socket.getInetAddress().getHostAddress());
					String message = string.substring(1, string.length()-1);
					message = message.replaceAll("%", ";");
					Url url = new Url(message,ipConfig);
					url.setDaemon(true);
					url.start();
				}
				System.out.println(string);
				// 向客户端发送消息
				outputStream = socket.getOutputStream();
				outputStream.write("OK".getBytes());
				System.out.println("OK");
			}
		} catch (Exception e) {
			System.out.println("客户端主动断开连接了");
		}
		// 操作结束，关闭socket
		try {
			socket.close();
		} catch (IOException e) {
			System.out.println("关闭连接出现异常");
			e.printStackTrace();
		}
	}
}
