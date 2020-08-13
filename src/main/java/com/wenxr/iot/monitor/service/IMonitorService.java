package com.wenxr.iot.monitor.service;

import java.util.List;

import com.google.gson.JsonObject;
import com.wenxr.iot.core.PageValueObject;
import com.wenxr.iot.model.Monitor;
import com.wenxr.iot.model.MonitorTcp;
public interface IMonitorService {
	/**
	 * 分页查询所有设备信息
	 * @param pageVo
	 * @return
	 */
	List<Object> getAllMonitor(String userCode, String equipmentCode, PageValueObject pageVo);
	/**
	 * app查询单条数据
	 * @param userCode
	 * @param equipmentCode
	 * @return
	 */
	List<MonitorTcp> getMonitor(String userCode, String equipmentCode);
	/**
	 * 获得封片数量
	 * @param userCode
	 * @param equipmentCode
	 * @return
	 */
	String getCoverNumber(String userCode, String equipmentCode);

}
