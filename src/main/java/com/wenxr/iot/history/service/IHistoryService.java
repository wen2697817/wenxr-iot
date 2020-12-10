package com.wenxr.iot.history.service;

import java.util.List;

import org.apache.poi.ss.usermodel.Workbook;

import com.wenxr.iot.core.PageValueObject;
import com.wenxr.iot.model.History;
public interface IHistoryService {
	
	/**
	 * web分页查询所有设备信息
	 * @param pageVo
	 * @return
	 */
	List<Object> getAllHistory(String userCode,String userCode1, String equipmentCode,String start,String end, PageValueObject pageVo);
	/**
	  * app查询运行
	  * @param userCode
	  * @param equipmentCode
	  * @param pageVo
	  * @return
	  */
	List<Object> getAllHistoryByCode(String userCode, String equipmentCode, PageValueObject pageVo);
	/**
	 * 查询历史记录，导出数据用
	 * @param equipmentCode
	 * @return
	 */
	List<History> getHistoryListByEquipmentCode(String equipmentCode , String userCode);
	/**
	 * 导出Excel
	 * @param list
	 * @param wb
	 * @param replace
	 * @return
	 */
	Object exportExcel(List<History> list, Workbook wb, String replace);
	/**
	 * 获取合计数量
	 * @param userCode
	 * @param equipmentCode
	 * @param start
	 * @param end
	 * @return
	 */
	Object getFengPianAndRanSe(String userCode, String equipmentCode, String start, String end);

}
