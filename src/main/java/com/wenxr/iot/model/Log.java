package com.wenxr.iot.model;


/**
 * 日志实体类
 * wenxr
 * 202087
 */
public class Log implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String logId;
	private String logType;
	private String clientIp;
	private String logContent;
	private String logTime;
	public Log() {
	}
	public Log(String logId, String logType, String clientIp, String logContent, String logTime) {
		super();
		this.logId = logId;
		this.logType = logType;
		this.clientIp = clientIp;
		this.logContent = logContent;
		this.logTime = logTime;
	}
	/**
	 * @return the logId
	 */
	public String getLogId() {
		return logId;
	}
	/**
	 * @param logId the logId to set
	 */
	public void setLogId(String logId) {
		this.logId = logId;
	}
	/**
	 * @return the logType
	 */
	public String getLogType() {
		return logType;
	}
	/**
	 * @param logType the logType to set
	 */
	public void setLogType(String logType) {
		this.logType = logType;
	}
	/**
	 * @return the clientIp
	 */
	public String getClientIp() {
		return clientIp;
	}
	/**
	 * @param clientIp the clientIp to set
	 */
	public void setClientIp(String clientIp) {
		this.clientIp = clientIp;
	}
	/**
	 * @return the logContent
	 */
	public String getLogContent() {
		return logContent;
	}
	/**
	 * @param logContent the logContent to set
	 */
	public void setLogContent(String logContent) {
		this.logContent = logContent;
	}
	/**
	 * @return the logTime
	 */
	public String getLogTime() {
		return logTime;
	}
	/**
	 * @param logTime the logTime to set
	 */
	public void setLogTime(String logTime) {
		this.logTime = logTime;
	}
}
