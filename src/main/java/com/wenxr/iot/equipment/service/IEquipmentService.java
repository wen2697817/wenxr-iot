package com.wenxr.iot.equipment.service;

import java.util.List;

import com.wenxr.iot.core.PageValueObject;
import com.wenxr.iot.model.Equipment;

public interface IEquipmentService {
	/**
	 * 分页查询所有设备信息
	 * @param pageVo
	 * @return
	 */
	List<Object> getAllEquipment(String equipmentName,String equipmentCode,PageValueObject pageVo);
	/**
	 * 通过编号统计数量
	 * @param equipmentCode
	 * @return
	 */
	int selectEquipmentByEquipmentCode(String equipmentId,String equipmentCode);
	/**
	 * 保存设备信息
	 * @param equipment
	 */
	void saveEquipment(Equipment equipment);
	/**
	 * 通过id查询
	 * @param equipmentId
	 * @return
	 */
	Equipment getEquipmentById(String equipmentId);
	/**
	 * 删除
	 * @param equipmentId
	 * @return
	 */
	String deleteE(String equipmentId);
	/**
	 * app查询设备
	 * @param userId
	 * @return
	 */
	List<Object> selectEquipmentsByUserId(String userId);

}
