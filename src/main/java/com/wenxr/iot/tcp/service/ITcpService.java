package com.wenxr.iot.tcp.service;

public interface ITcpService {
	/**
	 * 新增或者更新记录
	 * @param message
	 * @param ipConfig 
	 */
	void addOrUpdate(String message, String ipConfig);

}
