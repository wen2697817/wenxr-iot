package com.wenxr.iot.core;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * 描述：
 * 
 * <p>
 * &nbsp;&nbsp;&nbsp;&nbsp;业务层基类
 * </p>
 * 
 * 创建日期 2016-5-24
 * 
 * @author wxr
 * @version 1.0
 * 
 */
public abstract class BaseService {

	/**
	 * 日志记录
	 */
	protected Log log = LogFactory.getLog(getClass());

	@Resource
	protected CommonDao commonDao;





}
