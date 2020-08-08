package com.wenxr.iot.common.action;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

public class Url extends Thread {
	String message;// 发送数据
	String ipConfig;// 连接ip 端口信息

	public Url(String message, String ipConfig) {
		this.message = message;
		this.ipConfig = ipConfig;
	}

	@Override
	public void run() {
		String urll = null;
		try {
			urll = "http://127.0.0.1/iot/tcp-Tcp-addOrUpdate.action?"+"message=" + URLEncoder.encode(URLEncoder.encode(message,"UTF-8"),"UTF-8") + "&ipConfig=" + ipConfig;
		} catch (UnsupportedEncodingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			URL url = new URL(urll);
			HttpURLConnection urlcon = (HttpURLConnection) url.openConnection();
			urlcon.connect(); // 获取连接
			BufferedReader buffer = new BufferedReader(new InputStreamReader(urlcon.getInputStream(),"UTF-8"));
			StringBuffer bs = new StringBuffer();
			String l = null;
			while ((l = buffer.readLine()) != null) {
				bs.append(l).append("/n");
			}
			System.out.println(bs.toString());
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
