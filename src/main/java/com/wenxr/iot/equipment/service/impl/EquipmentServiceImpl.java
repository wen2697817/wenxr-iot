package com.wenxr.iot.equipment.service.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.wenxr.iot.core.BaseService;
import com.wenxr.iot.core.PageValueObject;
import com.wenxr.iot.equipment.service.IEquipmentService;
import com.wenxr.iot.model.Equipment;
import com.wenxr.iot.util.Tools;

@Repository
public class EquipmentServiceImpl extends BaseService implements IEquipmentService {

	public List<Object> getAllEquipment(String equipmentName, String equipmentCode, PageValueObject pageVo) {
		String hql = "select e.equipmentId,e.user.userName,e.equipmentCode,e.equipmentName,e.orderNumber from Equipment e where 1=1";
		if (!Tools.isEmpty(equipmentCode)) {
			hql = hql + " and e.equipmentCode like '%" + equipmentCode + "%'";
		}
		if (!Tools.isEmpty(equipmentName)) {
			hql = hql + " and e.equipmentName like '%" + equipmentName + "%'";
		}
		hql = hql + " order by e.user.userName asc,e.orderNumber asc";
		return commonDao.getObjectsByPage(hql, pageVo);
	}

	public int selectEquipmentByEquipmentCode(String equipmentId, String equipmentCode) {
		if (!Tools.isEmpty(equipmentId)) {
			Equipment equipment = commonDao.getObject(Equipment.class, equipmentId);
			if (equipmentCode.equals(equipment.getEquipmentCode())) {
				return 0;
			}
		}
		String hql = "from Equipment e where e.equipmentCode=?";
		List<Equipment> equipmentList = commonDao.getObjects(hql, new Object[] { equipmentCode });
		if (equipmentList != null) {
			return equipmentList.size();
		}
		return 0;
	}

	public void saveEquipment(Equipment equipment) {
		commonDao.addObject(equipment);
	}

	public Equipment getEquipmentById(String equipmentId) {
		return commonDao.getObject(Equipment.class, equipmentId);
	}

	public String deleteE(String equipmentId) {
		commonDao.delObject(Equipment.class, equipmentId);
		return "删除成功";
	}

	public List<Object> selectEquipmentsByUserId(String userId) {
		String hql = "select e.equipmentId,e.equipmentCode,e.equipmentName from Equipment e where e.user.userId=?";
		return commonDao.getObjects(hql, new Object[] { userId });
	}

}
