package com.wenxr.iot.run.service;

import java.util.List;

import com.wenxr.iot.core.PageValueObject;
public interface IRunService {
	/**
	 * 分页查询所有设备信息
	 * @param pageVo
	 * @return
	 */
	 List<Object> getAllRun(String userCode, String equipmentCode, String shelfId, String programName, PageValueObject pageVo);
	 /**
	  * app查询运行
	  * @param userCode
	  * @param equipmentCode
	  * @param pageVo
	  * @return
	  */
	List<Object> getAllRunByEquipmentCode(String userCode, String equipmentCode, PageValueObject pageVo);

}
