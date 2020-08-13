package com.wenxr.iot.core;

import java.io.File;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.apache.struts2.interceptor.SessionAware;

import com.wenxr.iot.model.User;
import com.wenxr.iot.util.Globals;
import com.wenxr.iot.util.SystemConstants;
import com.opensymphony.xwork2.ActionSupport;

/**
 * 描述：
 * 
 * <p>
 * &nbsp;&nbsp;&nbsp;&nbsp;Action基类
 * </p>
 * 
 * 创建日期 2016-5-24
 * 
 * @author wxr
 * @version 1.0
 * 
 */
public class BaseAction extends ActionSupport implements ServletRequestAware, SessionAware, ServletResponseAware {

	private static final long serialVersionUID = 1L;
	protected HttpServletRequest request;
	protected HttpServletResponse response;
	protected Map<String, Object> session;
	protected PageValueObject pageVo = null;
	protected String success = "true", msg = null,coverNumber=null;
	protected String basePath = ServletActionContext.getServletContext().getRealPath(File.separator);
	/**
	 * for ios status
	 */
	protected String code = SystemConstants.CODE_SUCCESS;
	protected Object data = null;

	// Struts Return Name
	protected final static String STATUS_JSON = "STATUS_JSON";
	protected final static String METHOD = "METHOD";
	protected final static String DEFINED = "DEFINED";
	protected String definedReturnResult = "";

	private int limit, page, start;

	/**
	 * empty action for debugger
	 * 
	 * @return
	 */
	public String empty() {
		return success();
	}

	/**
	 * @return the page
	 */
	public PageValueObject getPageVo() {
		return pageVo;
	}

	/**
	 * @param page
	 *            the page to set
	 */
	public void setPageVo(PageValueObject page) {
		this.pageVo = page;
	}

	/**
	 * @return the msg
	 */
	public String getMsg() {
		return msg;
	}

	/**
	 * @param msg
	 *            the msg to set
	 */
	public void setMsg(String msg) {
		this.msg = msg;
	}

	public String getCoverNumber() {
		return coverNumber;
	}

	public void setCoverNumber(String coverNumber) {
		this.coverNumber = coverNumber;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.apache.struts2.interceptor.ServletRequestAware#setServletRequest( javax.servlet.http.HttpServletRequest)
	 */
	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.apache.struts2.interceptor.ServletResponseAware#setServletResponse (javax.servlet.http.HttpServletResponse)
	 */
	public void setServletResponse(HttpServletResponse response) {
		this.response = response;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.apache.struts2.interceptor.SessionAware#setSession(java.util.Map)
	 */
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	/**
	 * @return the stationScope
	 */
	public String stationScope() {
		return (String) request.getSession().getAttribute(Globals.getProp("STATION_SCOPE"));
	}

	/**
	 * @return the trainScope
	 */
	public String trainScope() {
		return (String) request.getSession().getAttribute(Globals.getProp("TRAIN_SCOPE"));
	}

	/**
	 * @return the cityScope
	 */
	public String cityScope() {
		return (String) request.getSession().getAttribute(Globals.getProp("CITY_SCOPE"));
	}

	/**
	 * @return the status
	 */
	public boolean getSuccess() {
		return "true".equals(success);
	}

	/**
	 * @return the code
	 */
	public String getCode() {
		return code;
	}

	/**
	 * @return the data
	 */
	public Object getData() {
		return data;
	}

	/**
	 * 
	 * @return System.currentTimeMillis
	 */
	public String getTime() {
		return String.valueOf(System.currentTimeMillis());
	}

	/**
	 * @return the definedreturnresult
	 */
	public String getDefinedReturnResult() {
		return definedReturnResult.startsWith("/") ? definedReturnResult.substring(1) : definedReturnResult;
	}

	/**
	 * 执行成功的值填充
	 * 
	 * @param msg
	 * @param data
	 * @return
	 */
	protected String success(String msg, Object data) {
		this.success = "true";
		this.code = "200";
		this.msg = msg;
		this.data = data;
		if (StringUtils.isNotEmpty(this.definedReturnResult)) {
			if (request.getRequestURI().indexOf("/mobile/") < 0) {
				return DEFINED;
			}
		}
		return STATUS_JSON;
	}

	/**
	 * 执行成功的值填充
	 * 
	 * @param msg
	 * @return
	 */
	protected String success(String msg) {
		return this.success(msg, this.data);
	}

	/**
	 * 执行成功的空值填充
	 * 
	 * @return
	 */
	protected String success() {
		return this.success(this.msg, this.data);
	}

	/**
	 * 执行失败的值填充
	 * 
	 * @param code
	 * @param msg
	 * @param data
	 * @return
	 */
	protected String failure(String code, String msg, Object data) {
		this.success = "false";
		this.code = code;
		this.msg = msg;
		this.data = data;
		if (StringUtils.isNotEmpty(this.definedReturnResult)) {
			if (request.getRequestURI().indexOf("/mobile/") < 0) {
				if ("201".equals(this.code)) {
					// throw new RuntimeException(msg);
					return DEFINED;
				} else {
					return DEFINED;
				}
			}
		}

		return STATUS_JSON;
	}

	/**
	 * 执行失败的值填充
	 * 
	 * @param code
	 * @param msg
	 * @return
	 */
	protected String failure(String code, String msg) {
		return this.failure(code, msg, this.data);
	}

	/**
	 * 执行失败的值填充（异常情况）
	 * 
	 * @param msg
	 * @return
	 */
	protected String failure(String msg) {
		return this.failure("201", msg, this.data);
	}

	/**
	 * 执行失败的值填充（异常情况）
	 * 
	 * @param msg
	 * @return
	 */
	protected String failure(Exception e) {
		return this.failure(e.getMessage());
	}

	/**
	 * @return the limit
	 */
	public int getLimit() {
		return limit;
	}

	/**
	 * @param limit
	 *            the limit to set
	 */
	public void setLimit(int limit) {
		this.limit = limit;
		pageVo = pageVo == null ? new PageValueObject() : pageVo;
		pageVo.setLimit(limit);
	}

	/**
	 * @return the page
	 */
	public int getPage() {
		return page;
	}

	/**
	 * @param page
	 *            the page to set
	 */
	public void setPage(int page) {
		this.page = page;
	}

	/**
	 * @return the start
	 */
	public int getStart() {
		return start;
	}

	/**
	 * @param start
	 *            the start to set
	 */
	public void setStart(int start) {
		this.start = start;
		pageVo = pageVo == null ? new PageValueObject() : pageVo;
		pageVo.setStart(start);
	}

	/**
	 * @return the total
	 */
	public int getTotal() {
		return pageVo == null ? 0 : pageVo.getTotal();
	}

	/**
	 * 获取请求根路径
	 * 
	 * @return
	 */
	protected String requestPath() {
		String path = request.getContextPath();
		return request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
	}

	/**
	 * 当前用户
	 * 
	 * @return
	 */
	protected User curUser() {
		return Globals.getLoginInfoBean(request.getSession());
	}

	/**
	 * 
	 * @param str
	 */
	protected void valEmpty(String... str) {
		int i = 0;
		for (String s : str) {
			if (s == null || StringUtils.isEmpty(s.trim())) {
				this.addFieldError("202", "str[" + (i++) + "]为空");
			}
		}
	}

	protected void valEmptyReturn(String... str) throws Exception {
		valEmpty(str);
		valException();
	}

	private void valException() throws Exception {
		if (this.hasFieldErrors()) {
			// 中断validate方法的执行，需要try-catch-finally，且在finally里调用valFieldError();
			throw new Exception();
		}
	}

	protected void valFieldError() {
		if (!this.hasFieldErrors()) {
			return;
		}
		this.code = "";
		this.msg = "";
		Map<String, List<String>> map = this.getFieldErrors();
		Iterator<String> key = map.keySet().iterator();
		while (key.hasNext()) {
			String k = key.next();
			this.code += k + ",";
			List<String> list = map.get(k);
			for (String s : list) {
				this.msg += s + ",";
			}
		}
		this.code = this.code.isEmpty() ? SystemConstants.CODE_SUCCESS : this.code.substring(0, this.code.length() - 1);
		if (request.getRequestURI().indexOf("/mobile/") >= 0) {
			return;
		}
		if ("XMLHttpRequest".equals(request.getHeader("X-Requested-With"))) {
			return;
		} else {
			return;
		}
	}
}
