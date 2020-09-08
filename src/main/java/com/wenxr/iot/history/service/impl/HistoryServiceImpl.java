package com.wenxr.iot.history.service.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.wenxr.iot.core.BaseService;
import com.wenxr.iot.core.PageValueObject;
import com.wenxr.iot.history.service.IHistoryService;
import com.wenxr.iot.util.Tools;

@Repository
public class HistoryServiceImpl extends BaseService implements IHistoryService {

	public List<Object> getAllHistory(String userCode, String equipmentCode, PageValueObject pageVo) {
		String hql = "select h.userCode,h.equipmentCode,h.coverNumber,h.dyeNumber,h.productionDate from History h where 1=1";
		if (!Tools.isEmpty(userCode)) {
			hql = hql + " and h.userCode like '%" + userCode + "%'";
		}
		if (!Tools.isEmpty(equipmentCode)) {
			hql = hql + " and h.equipmentCode like '%" + equipmentCode + "%'";
		}
		hql = hql + " order by h.productionDate desc";
		return commonDao.getObjectsByPage(hql, pageVo);
	}

	public List<Object> getAllHistoryByCode(String userCode, String equipmentCode, PageValueObject pageVo) {
		String hql = "select h.coverNumber,h.dyeNumber,h.productionDate from History h where 1=1";
		if (!Tools.isEmpty(userCode)) {
			hql = hql + " and h.userCode='" + userCode + "'";
		}
		if (!Tools.isEmpty(equipmentCode)) {
			hql = hql + " and h.equipmentCode = '" + equipmentCode + "'";
		}
		hql = hql + " order by h.productionDate desc";
		return commonDao.getObjectsByPage(hql, pageVo);
	}

}
