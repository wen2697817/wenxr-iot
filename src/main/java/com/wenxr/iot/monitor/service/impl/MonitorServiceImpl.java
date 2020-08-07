package com.wenxr.iot.monitor.service.impl;

import java.util.List;


import org.springframework.stereotype.Repository;

import com.wenxr.iot.core.BaseService;
import com.wenxr.iot.core.PageValueObject;
import com.wenxr.iot.model.Monitor;
import com.wenxr.iot.monitor.service.IMonitorService;
import com.wenxr.iot.util.Tools;

@Repository
public class MonitorServiceImpl extends BaseService implements IMonitorService {

	public List<Object> getAllMonitor(String userCode, String equipmentCode, PageValueObject pageVo) {
		String hql = "select m.userCode,m.equipmentCode,m.coverNumber,m.g1,m.g2,m.g3,m.g4,"
				+ "m.g5,m.g6,m.g7,m.g8,m.g9,m.g10,m.g11,m.g12,"
				+"m.g13,m.g14,m.g15,m.g16,m.g17,m.g18,m.g19,m.g20,m.g21,m.g22,m.g23,m.g24,"
				+"m.g25,m.g26,m.g27,m.g28,m.g29,m.g30,m.g31,m.g32"
				+ " from Monitor m where 1=1";
		if (!Tools.isEmpty(userCode)) {
			hql = hql + " and m.userCode like '%" + userCode + "%'";
		}
		if (!Tools.isEmpty(equipmentCode)) {
			hql = hql + " and m.equipmentCode like '%" + equipmentCode + "%'";
		}
		hql = hql + " order by m.userCode asc,m.equipmentCode asc";
		return commonDao.getObjectsByPage(hql, pageVo);
	}

	public Monitor getMonitor(String userCode, String equipmentCode) {
		String hql = "from Monitor m where m.userCode=? and m.equipmentCode=?";
		List<Monitor> monitorList = commonDao.getObjects(hql, new Object[] {userCode,equipmentCode});
		if(monitorList==null||monitorList.size()==0) {
			return null;
		}
		return monitorList.get(0);
	}

}
