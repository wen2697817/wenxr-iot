package com.wenxr.iot.monitor.service.impl;

import java.util.ArrayList;
import java.util.List;


import org.springframework.stereotype.Repository;

import com.google.gson.JsonObject;
import com.wenxr.iot.core.BaseService;
import com.wenxr.iot.core.PageValueObject;
import com.wenxr.iot.model.Monitor;
import com.wenxr.iot.model.MonitorTcp;
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

	public List<MonitorTcp> getMonitor(String userCode, String equipmentCode) {
		String hql = "from Monitor m where m.userCode=? and m.equipmentCode=?";
		List<Monitor> monitorList = commonDao.getObjects(hql, new Object[] {userCode,equipmentCode});
		if(monitorList==null||monitorList.size()==0) {
			return null;
		}
		Monitor m = monitorList.get(0);
		List<MonitorTcp> mtList = new ArrayList<MonitorTcp>();
		MonitorTcp mt = new MonitorTcp();
		mt.setLocation("1");
		mt.setStain(m.getG1());
		mt.setProgramName(m.getGn1());
		mtList.add(mt);
		mt = new MonitorTcp();
		mt.setLocation("2");
		mt.setStain(m.getG2());
		mt.setProgramName(m.getGn2());
		mtList.add(mt);
		mt = new MonitorTcp();
		mt.setLocation("3");
		mt.setStain(m.getG3());
		mt.setProgramName(m.getGn3());
		mtList.add(mt);
		mt = new MonitorTcp();
		mt.setLocation("4");
		mt.setStain(m.getG4());
		mt.setProgramName(m.getGn4());
		mtList.add(mt);
		mt = new MonitorTcp();
		mt.setLocation("5");
		mt.setStain(m.getG5());
		mt.setProgramName(m.getGn5());
		mtList.add(mt);
		mt = new MonitorTcp();
		mt.setLocation("6");
		mt.setStain(m.getG6());
		mt.setProgramName(m.getGn6());
		mtList.add(mt);
		mt = new MonitorTcp();
		mt.setLocation("7");
		mt.setStain(m.getG7());
		mt.setProgramName(m.getGn7());
		mtList.add(mt);
		mt = new MonitorTcp();
		mt.setLocation("8");
		mt.setStain(m.getG8());
		mt.setProgramName(m.getGn8());
		mtList.add(mt);
		mt = new MonitorTcp();
		mt.setLocation("9");
		mt.setStain(m.getG9());
		mt.setProgramName(m.getGn9());
		mtList.add(mt);
		mt = new MonitorTcp();
		mt.setLocation("10");
		mt.setStain(m.getG10());
		mt.setProgramName(m.getGn10());
		mtList.add(mt);
		mt = new MonitorTcp();
		mt.setLocation("11");
		mt.setStain(m.getG11());
		mt.setProgramName(m.getGn11());
		mtList.add(mt);
		mt = new MonitorTcp();
		mt.setLocation("12");
		mt.setStain(m.getG12());
		mt.setProgramName(m.getGn12());
		mtList.add(mt);
		mt = new MonitorTcp();
		mt.setLocation("13");
		mt.setStain(m.getG13());
		mt.setProgramName(m.getGn13());
		mtList.add(mt);
		mt = new MonitorTcp();
		mt.setLocation("14");
		mt.setStain(m.getG14());
		mt.setProgramName(m.getGn14());
		mtList.add(mt);
		mt = new MonitorTcp();
		mt.setLocation("15");
		mt.setStain(m.getG15());
		mt.setProgramName(m.getGn15());
		mtList.add(mt);
		mt = new MonitorTcp();
		mt.setLocation("16");
		mt.setStain(m.getG16());
		mt.setProgramName(m.getGn16());
		mtList.add(mt);
		mt = new MonitorTcp();
		mt.setLocation("17");
		mt.setStain(m.getG17());
		mt.setProgramName(m.getGn17());
		mtList.add(mt);
		mt = new MonitorTcp();
		mt.setLocation("18");
		mt.setStain(m.getG18());
		mt.setProgramName(m.getGn18());
		mtList.add(mt);
		mt = new MonitorTcp();
		mt.setLocation("19");
		mt.setStain(m.getG19());
		mt.setProgramName(m.getGn19());
		mtList.add(mt);
		mt = new MonitorTcp();
		mt.setLocation("20");
		mt.setStain(m.getG20());
		mt.setProgramName(m.getGn20());
		mtList.add(mt);
		mt = new MonitorTcp();
		mt.setLocation("21");
		mt.setStain(m.getG21());
		mt.setProgramName(m.getGn21());
		mtList.add(mt);
		mt = new MonitorTcp();
		mt.setLocation("22");
		mt.setStain(m.getG22());
		mt.setProgramName(m.getGn22());
		mtList.add(mt);
		mt = new MonitorTcp();
		mt.setLocation("23");
		mt.setStain(m.getG23());
		mt.setProgramName(m.getGn23());
		mtList.add(mt);
		mt = new MonitorTcp();
		mt.setLocation("24");
		mt.setStain(m.getG24());
		mt.setProgramName(m.getGn24());
		mtList.add(mt);
		mt = new MonitorTcp();
		mt.setLocation("25");
		mt.setStain(m.getG25());
		mt.setProgramName(m.getGn25());
		mtList.add(mt);
		mt = new MonitorTcp();
		mt.setLocation("26");
		mt.setStain(m.getG26());
		mt.setProgramName(m.getGn26());
		mtList.add(mt);
		mt = new MonitorTcp();
		mt.setLocation("27");
		mt.setStain(m.getG27());
		mt.setProgramName(m.getGn27());
		mtList.add(mt);
		mt = new MonitorTcp();
		mt.setLocation("28");
		mt.setStain(m.getG28());
		mt.setProgramName(m.getGn28());
		mtList.add(mt);
		mt = new MonitorTcp();
		mt.setLocation("29");
		mt.setStain(m.getG29());
		mt.setProgramName(m.getGn29());
		mtList.add(mt);
		mt = new MonitorTcp();
		mt.setLocation("30");
		mt.setStain(m.getG30());
		mt.setProgramName(m.getGn30());
		mtList.add(mt);
		mt = new MonitorTcp();
		mt.setLocation("31");
		mt.setStain(m.getG31());
		mt.setProgramName(m.getGn31());
		mtList.add(mt);
		mt = new MonitorTcp();
		mt.setLocation("32");
		mt.setStain(m.getG32());
		mt.setProgramName(m.getGn32());
		mtList.add(mt);
		
		return mtList;
	}

	public String getCoverNumber(String userCode, String equipmentCode) {
		String hql = "from Monitor m where m.userCode=? and m.equipmentCode=?";
		List<Monitor> monitorList = commonDao.getObjects(hql, new Object[] {userCode,equipmentCode});
		if(monitorList==null||monitorList.size()==0) {
			return null;
		}
		Monitor m = monitorList.get(0);
		return m.getCoverNumber();
	}

}
