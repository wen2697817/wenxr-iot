package com.wenxr.iot.model;

/**
 * 历史实体类
 * wenxr
 * 202087
 */
public class History implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String historyId;
	private String userCode;
	private String equipmentCode;
	private String coverNumber;
	private String dyeNumber;
	private String productionDate;
	public History() {
	}
	
	public History(String historyId, String userCode, String equipmentCode, String coverNumber, String dyeNumber,
			String productionDate) {
		super();
		this.historyId = historyId;
		this.userCode = userCode;
		this.equipmentCode = equipmentCode;
		this.coverNumber = coverNumber;
		this.dyeNumber = dyeNumber;
		this.productionDate = productionDate;
	}

	/**
	 * @return the historyId
	 */
	public String getHistoryId() {
		return historyId;
	}
	/**
	 * @param historyId the historyId to set
	 */
	public void setHistoryId(String historyId) {
		this.historyId = historyId;
	}
	/**
	 * @return the userCode
	 */
	public String getUserCode() {
		return userCode;
	}
	/**
	 * @param userCode the userCode to set
	 */
	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}
	/**
	 * @return the equipmentCode
	 */
	public String getEquipmentCode() {
		return equipmentCode;
	}
	/**
	 * @param equipmentCode the equipmentCode to set
	 */
	public void setEquipmentCode(String equipmentCode) {
		this.equipmentCode = equipmentCode;
	}
	/**
	 * @return the coverNumber
	 */
	public String getCoverNumber() {
		return coverNumber;
	}
	/**
	 * @param coverNumber the coverNumber to set
	 */
	public void setCoverNumber(String coverNumber) {
		this.coverNumber = coverNumber;
	}
	/**
	 * @return the dyeNumber
	 */
	public String getDyeNumber() {
		return dyeNumber;
	}
	/**
	 * @param dyeNumber the dyeNumber to set
	 */
	public void setDyeNumber(String dyeNumber) {
		this.dyeNumber = dyeNumber;
	}
	/**
	 * @return the productionDate
	 */
	public String getProductionDate() {
		return productionDate;
	}
	/**
	 * @param productionDate the productionDate to set
	 */
	public void setProductionDate(String productionDate) {
		this.productionDate = productionDate;
	}
}
