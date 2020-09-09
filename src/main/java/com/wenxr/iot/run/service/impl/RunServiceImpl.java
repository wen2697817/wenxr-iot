package com.wenxr.iot.run.service.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.wenxr.iot.core.BaseService;
import com.wenxr.iot.core.PageValueObject;
import com.wenxr.iot.run.service.IRunService;
import com.wenxr.iot.util.Tools;

@Repository
public class RunServiceImpl extends BaseService implements IRunService {

	public List<Object> getAllRun(String userCode, String equipmentCode, String shelfId, String programName,
			PageValueObject pageVo) {
		String hql = "select r.userCode,r.equipmentCode,r.shelfId,r.programName,r.siteLocation,r.stepTime,r.totalTime from Run r where 1=1";
		if (!Tools.isEmpty(userCode)) {
			hql = hql + " and r.userCode like '%" + userCode + "%'";
		}
		if (!Tools.isEmpty(equipmentCode)) {
			hql = hql + " and r.equipmentCode like '%" + equipmentCode + "%'";
		}
		if (!Tools.isEmpty(shelfId)) {
			hql = hql + " and r.shelfId like '%" + shelfId + "%'";
		}
		if (!Tools.isEmpty(programName)) {
			hql = hql + " and r.programName like '%" + programName + "%'";
		}
		hql = hql + " order by r.userCode asc,r.equipmentCode asc,r.shelfId asc";
		return commonDao.getObjectsByPage(hql, pageVo);
	}

	public List<Object> getAllRunByEquipmentCode(String userCode, String equipmentCode, PageValueObject pageVo) {
		String hql = "select r.shelfId,r.programName,r.siteLocation,r.stepTime,r.totalTime from Run r where 1=1";
		if (!Tools.isEmpty(userCode)) {
			hql = hql + " and r.userCode='" + userCode + "'";
		}
		if (!Tools.isEmpty(equipmentCode)) {
			hql = hql + " and r.equipmentCode = '" + equipmentCode + "'";
		}
		hql = hql + " order by r.userCode asc,r.equipmentCode asc";
		return commonDao.getObjectsByPage(hql, pageVo);
	}

}
