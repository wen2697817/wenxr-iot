package com.wenxr.iot.model;

/**
 * 运行实体类
 * wenxr
 * 202087
 */
public class Run implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String runId;
	private String userCode;
	private String equipmentCode;
	private String shelfId;
	private String programName;
	private String siteLocation;
	private String stepTime;
	private String totalTime;
	public Run() {
	}

	public Run(String runId,String userCode,String equipmentCode,String shelfId,String programName,
			String siteLocation,String stepTime,String totalTime) {
		this.runId = runId;
		this.userCode = userCode;
		this.equipmentCode = equipmentCode;
		this.shelfId = shelfId;
		this.programName = programName;
		this.siteLocation = siteLocation;
		this.stepTime = stepTime;
		this.totalTime = totalTime;
	}

	public String getRunId() {
		return runId;
	}

	public void setRunId(String runId) {
		this.runId = runId;
	}

	public String getUserCode() {
		return userCode;
	}

	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}

	public String getEquipmentCode() {
		return equipmentCode;
	}

	public void setEquipmentCode(String equipmentCode) {
		this.equipmentCode = equipmentCode;
	}

	public String getShelfId() {
		return shelfId;
	}

	public void setShelfId(String shelfId) {
		this.shelfId = shelfId;
	}

	public String getProgramName() {
		return programName;
	}

	public void setProgramName(String programName) {
		this.programName = programName;
	}

	public String getSiteLocation() {
		return siteLocation;
	}

	public void setSiteLocation(String siteLocation) {
		this.siteLocation = siteLocation;
	}

	public String getStepTime() {
		return stepTime;
	}

	public void setStepTime(String stepTime) {
		this.stepTime = stepTime;
	}

	public String getTotalTime() {
		return totalTime;
	}

	public void setTotalTime(String totalTime) {
		this.totalTime = totalTime;
	}

}
