/*	
 * 
 * QiWenSoftWare Copyright (C) 2015 QiWenSoftWare, Co.ltd . 
 * All rights reserved.
 *			 
 * Package:  com.wenxr.iot.util
 * FileName: SystemConstants.java
 * 
 */
package com.wenxr.iot.util;

/**
 * 描述：
 * 
 * <p>
 * &nbsp;&nbsp;&nbsp;&nbsp;系统常量
 * </p>
 * 
 * 创建日期 2016年5月24日
 * 
 * @author wxr
 * @version 1.0
 * 
 */
public class SystemConstants {

	/**
	 * 网站域名
	 */
	public final static String DOMAIN = "http://127.0.0.1:8084/iot";

	/**
	 * 盐值
	 */
	public final static String USER_PASSWORD_SALT = "";
	/**
	 * 初始密码
	 */
	public final static String INIT_PASSWORD = "000000";

	/**
	 * 执行成功后状态码
	 */
	public final static String CODE_SUCCESS = "200";

	/**
	 * 执行失败后的状态码
	 */
	public final static String CODE_FAILURE = "201";

	/**
	 * 手机验证码失效时间（分钟）
	 */
	public final static short MOBILE_SECURITY_CODE_TIME_OUT_MINUTE = 10;

	/**
	 * 邮箱验证超时时间（小时）
	 */
	public final static short EMAIL_VALIDATE_TIME_OUT_HOUR = 24;
	/**
	 * 自动确认付款时间限制（天）
	 */
	public final static short AUTO_AFFIRM_PAY = 3;
	/**
	 * 自动退款时间（小时）
	 */
	public final static short AUTO_REFUND = 24;

	/**
	 * 邮件发送标题头
	 */
	public final static String EMAIL_HEADER = "keyao";

	/**
	 * 图片验证码的session name
	 */
	public final static String SESSION_NAME_IMAGE_SECURITY_CODE = "imageSecurityCode";

	/**
	 * 手机验证码的session name
	 */
	public final static String SESSION_NAME_MOBILE_SECURITY_CODE = "mobileSecurityCode";

	/**
	 * 手机验证码超时时间的session name
	 */
	public final static String SESSION_NAME_MOBILE_SECURITY_CODE_TIME_LONG = "mobileSecurityCodeTimelong";

	/**
	 * 编码
	 */
	public static final String ENCODE_GB2312 = "GB2312";
	public static final String ENCODE_ISO_8859_1 = "ISO-8859-1";
	public static final String ENCODE_UTF_8 = "UTF-8";
	public static final String ENCODE_GBK = "GBK";

}
