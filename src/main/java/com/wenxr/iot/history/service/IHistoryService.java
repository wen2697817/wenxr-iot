package com.wenxr.iot.history.service;

import java.util.List;

import com.wenxr.iot.core.PageValueObject;
public interface IHistoryService {
	
	/**
	 * web分页查询所有设备信息
	 * @param pageVo
	 * @return
	 */
	List<Object> getAllHistory(String userCode, String equipmentCode, PageValueObject pageVo);
	/**
	  * app查询运行
	  * @param userCode
	  * @param equipmentCode
	  * @param pageVo
	  * @return
	  */
	List<Object> getAllHistoryByCode(String userCode, String equipmentCode, PageValueObject pageVo);

}
