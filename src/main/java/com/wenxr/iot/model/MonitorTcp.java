package com.wenxr.iot.model;

public class MonitorTcp {
	String location;
	String stain;
	String programName;
	public MonitorTcp() {
		
	}
	public MonitorTcp(String location, String stain, String programName) {
		super();
		this.location = location;
		this.stain = stain;
		this.programName = programName;
	}
	/**
	 * @return the location
	 */
	public String getLocation() {
		return location;
	}
	/**
	 * @param location the location to set
	 */
	public void setLocation(String location) {
		this.location = location;
	}
	/**
	 * @return the stain
	 */
	public String getStain() {
		return stain;
	}
	/**
	 * @param stain the stain to set
	 */
	public void setStain(String stain) {
		this.stain = stain;
	}
	/**
	 * @return the programName
	 */
	public String getProgramName() {
		return programName;
	}
	/**
	 * @param programName the programName to set
	 */
	public void setProgramName(String programName) {
		this.programName = programName;
	}
	
}
