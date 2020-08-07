package com.wenxr.iot.util;

import java.util.ResourceBundle;

import javax.servlet.http.HttpSession;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.wenxr.iot.model.User;

/**
 * 描述：
 * 
 * <p>
 * &nbsp;&nbsp;&nbsp;&nbsp;Global manifest constants for the entire Framework
 * </p>
 * 
 * 创建日期 2016-5-24
 * 
 * @author wxr
 * @version 1.0
 * 
 */
public final class Globals {
	/**
	 * global.properties 文件
	 */
	private static ResourceBundle resourceBundle = ResourceBundle.getBundle("global");

	/**
	 * 获取application context
	 */
	private static ApplicationContext ac = null;

	/**
	 * 通过key名获取global.properties的值，字符串类型
	 * 
	 * @param key
	 * @return 返回字符串
	 */
	public static String getProp(String key) {
		return resourceBundle.getString(key);
	}

	/**
	 * 通过key名获取global.properties的值，整数类型
	 * 
	 * @param key
	 * @return 返回字符串
	 */
	public static int getPropInt(String key) {
		String str = Globals.getProp(key);
		int rt = 0;
		try {
			rt = str == null ? 0 : Integer.parseInt(str.trim());
		} catch (Exception e) {
			rt = 0;
		}
		return rt;
	}

	/**
	 * 通过key名获取global.properties的值，小数类型
	 * 
	 * @param key
	 * @return 返回字符串
	 */
	public static float getPropFloat(String key) {
		String str = Globals.getProp(key);
		float rt = 0f;
		try {
			rt = str == null ? 0f : Float.parseFloat(str.trim());
		} catch (Exception e) {
			rt = 0f;
		}
		return rt;
	}

	/**
	 * 获取当前登录者的bean，当前登录者信息内容由UserBean在登录时确定
	 * 
	 * @param session
	 * @return
	 */
	public static User getLoginInfoBean(HttpSession session) {
		return (User) session.getAttribute(Globals.getProp("LOGIN_INFO_BEAN"));
	}

	/**
	 * /** 获取spring的IOC bean对象
	 * 
	 * @param beanName
	 * @return
	 */
	public static Object getBean(String beanName) {
		if (ac == null) {
			ac = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
		}
		return ac.getBean(beanName);
	}
}