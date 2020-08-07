package com.wenxr.iot.model;

/**
 * 设备实体类
 * wenxr
 * 202086
 */
public class Equipment implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String equipmentId;
	private User user;
	private String equipmentCode;
	private String equipmentName;
	private int orderNumber;
	public Equipment() {
	}

	public Equipment(String equipmentId, User user, String equipmentCode,
			String equipmentName, int orderNumber) {
		this.user = user;
		this.equipmentId = equipmentId;
		this.equipmentCode = equipmentCode;
		this.equipmentName = equipmentName;
		this.orderNumber = orderNumber;
	}

	public String getEquipmentId() {
		return equipmentId;
	}

	public void setEquipmentId(String equipmentId) {
		this.equipmentId = equipmentId;
	}
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getEquipmentCode() {
		return equipmentCode;
	}

	public void setEquipmentCode(String equipmentCode) {
		this.equipmentCode = equipmentCode;
	}

	public String getEquipmentName() {
		return equipmentName;
	}

	public void setEquipmentName(String equipmentName) {
		this.equipmentName = equipmentName;
	}

	public int getOrderNumber() {
		return orderNumber;
	}

	public void setOrderNumber(int orderNumber) {
		this.orderNumber = orderNumber;
	}
}
