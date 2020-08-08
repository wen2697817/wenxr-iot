package com.wenxr.iot.tcp.action;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

import javax.annotation.Resource;

import com.wenxr.iot.core.BaseAction;
import com.wenxr.iot.tcp.service.ITcpService;
/**
 * tcp数据处理
 * @author wenxr
 *
 */
public class TcpAction extends BaseAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Resource
	private ITcpService tcpService;
	/**
	 * 接收客户端数据，保存或者更新
	 * @return
	 */
	public String addOrUpdate() {
		String message = request.getParameter("message");
		try {
			message = URLDecoder.decode(message, "utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		String ipConfig = request.getParameter("ipConfig");
		tcpService.addOrUpdate(message,ipConfig);
		return this.success();
		
	}
}
