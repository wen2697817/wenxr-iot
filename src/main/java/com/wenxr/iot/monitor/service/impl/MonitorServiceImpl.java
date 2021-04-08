package com.wenxr.iot.monitor.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.wenxr.iot.core.BaseService;
import com.wenxr.iot.core.PageValueObject;
import com.wenxr.iot.model.Monitor;
import com.wenxr.iot.model.MonitorTcp;
import com.wenxr.iot.model.Run;
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

	public List<List<MonitorTcp>> getMonitor(String userCode, String equipmentCode) {
		List<List<MonitorTcp>> monitorListList = new ArrayList<List<MonitorTcp>>();
		String hql = "from Monitor m where m.userCode=? and m.equipmentCode=?";
		List<Monitor> monitorList = commonDao.getObjects(hql, new Object[] {userCode,equipmentCode});
		if(monitorList==null||monitorList.size()==0) {
			return null;
		}
		Monitor mm = monitorList.get(0);
		int e6 = equipmentCode.indexOf("MidE6");
		int e7 = equipmentCode.indexOf("MidE7");
		int cw = equipmentCode.indexOf("MidCW");
		hql = "from Run r where r.userCode=? and r.equipmentCode=?";
		List<Run> runList = commonDao.getObjects(hql, new Object[] {userCode,equipmentCode});
		if(runList==null||runList.size()==0) {
			return null;
		}
		Monitor m = getMonitorForRun(mm,runList);
		List<MonitorTcp> mtList;
		MonitorTcp mt;
		if(e6>=0) {//显示24个
			mtList = new ArrayList<MonitorTcp>();
			mt = new MonitorTcp();
			mt.setLocation("");
			mt.setStain("-1");
			mt.setProgramName("");
			mtList.add(mt);
			mt = new MonitorTcp();
			mt.setLocation("");
			mt.setStain("-1");
			mt.setProgramName("");
			mtList.add(mt);
			mt = new MonitorTcp();
			mt.setLocation("");
			mt.setStain("-1");
			mt.setProgramName("");
			mtList.add(mt);
			mt = new MonitorTcp();
			mt.setLocation("13");
			mt.setStain(m.getG13());
			mt.setProgramName(m.getGn13());
			mtList.add(mt);
			mt = new MonitorTcp();
			mt.setLocation("9");
			mt.setStain(m.getG9());
			mt.setProgramName(m.getGn9());
			mtList.add(mt);
			mt = new MonitorTcp();
			mt.setLocation("5");
			mt.setStain(m.getG5());
			mt.setProgramName(m.getGn5());
			mtList.add(mt);
			mt = new MonitorTcp();
			mt.setLocation("1");
			mt.setStain(m.getG1());
			mt.setProgramName(m.getGn1());
			mtList.add(mt);
			monitorListList.add(mtList);
			
			mtList = new ArrayList<MonitorTcp>();
			mt = new MonitorTcp();
			mt.setLocation("");
			mt.setStain("-1");
			mt.setProgramName("");
			mtList.add(mt);
			mt = new MonitorTcp();
			mt.setLocation("20");
			mt.setStain(m.getG20());
			mt.setProgramName(m.getGn20());
			mtList.add(mt);
			mt = new MonitorTcp();
			mt.setLocation("17");
			mt.setStain(m.getG17());
			mt.setProgramName(m.getGn17());
			mtList.add(mt);
			mt = new MonitorTcp();
			mt.setLocation("14");
			mt.setStain(m.getG14());
			mt.setProgramName(m.getGn14());
			mtList.add(mt);
			mt = new MonitorTcp();
			mt.setLocation("10");
			mt.setStain(m.getG10());
			mt.setProgramName(m.getGn10());
			mtList.add(mt);
			mt = new MonitorTcp();
			mt.setLocation("6");
			mt.setStain(m.getG6());
			mt.setProgramName(m.getGn6());
			mtList.add(mt);
			mt = new MonitorTcp();
			mt.setLocation("2");
			mt.setStain(m.getG2());
			mt.setProgramName(m.getGn2());
			mtList.add(mt);
			monitorListList.add(mtList);
			
			mtList = new ArrayList<MonitorTcp>();
			mt = new MonitorTcp();
			mt.setLocation("23");
			mt.setStain(m.getG23());
			mt.setProgramName(m.getGn23());
			mtList.add(mt);
			mt = new MonitorTcp();
			mt.setLocation("21");
			mt.setStain(m.getG21());
			mt.setProgramName(m.getGn21());
			mtList.add(mt);
			mt = new MonitorTcp();
			mt.setLocation("18");
			mt.setStain(m.getG18());
			mt.setProgramName(m.getGn18());
			mtList.add(mt);
			mt = new MonitorTcp();
			mt.setLocation("15");
			mt.setStain(m.getG15());
			mt.setProgramName(m.getGn15());
			mtList.add(mt);
			mt = new MonitorTcp();
			mt.setLocation("11");
			mt.setStain(m.getG11());
			mt.setProgramName(m.getGn11());
			mtList.add(mt);
			mt = new MonitorTcp();
			mt.setLocation("7");
			mt.setStain(m.getG7());
			mt.setProgramName(m.getGn7());
			mtList.add(mt);
			mt = new MonitorTcp();
			mt.setLocation("3");
			mt.setStain(m.getG3());
			mt.setProgramName(m.getGn3());
			mtList.add(mt);
			monitorListList.add(mtList);
			
			mtList = new ArrayList<MonitorTcp>();
			mt = new MonitorTcp();
			mt.setLocation("24");
			mt.setStain(m.getG24());
			mt.setProgramName(m.getGn24());
			mtList.add(mt);
			mt = new MonitorTcp();
			mt.setLocation("22");
			mt.setStain(m.getG22());
			mt.setProgramName(m.getGn22());
			mtList.add(mt);
			mt = new MonitorTcp();
			mt.setLocation("19");
			mt.setStain(m.getG19());
			mt.setProgramName(m.getGn19());
			mtList.add(mt);
			mt = new MonitorTcp();
			mt.setLocation("16");
			mt.setStain(m.getG16());
			mt.setProgramName(m.getGn16());
			mtList.add(mt);
			mt = new MonitorTcp();
			mt.setLocation("12");
			mt.setStain(m.getG12());
			mt.setProgramName(m.getGn12());
			mtList.add(mt);
			mt = new MonitorTcp();
			mt.setLocation("8");
			mt.setStain(m.getG8());
			mt.setProgramName(m.getGn8());
			mtList.add(mt);
			mt = new MonitorTcp();
			mt.setLocation("4");
			mt.setStain(m.getG4());
			mt.setProgramName(m.getGn4());
			mtList.add(mt);
			monitorListList.add(mtList);
		}
		if(e7>=0) {//显示27个
			mtList = new ArrayList<MonitorTcp>();
			mt = new MonitorTcp();
			mt.setLocation("");
			mt.setStain("-1");
			mt.setProgramName("");
			mtList.add(mt);
			mt = new MonitorTcp();
			mt.setLocation("");
			mt.setStain("-1");
			mt.setProgramName("");
			mtList.add(mt);
			mt = new MonitorTcp();
			mt.setLocation("13");
			mt.setStain(m.getG13());
			mt.setProgramName(m.getGn13());
			mtList.add(mt);
			mt = new MonitorTcp();
			mt.setLocation("7");
			mt.setStain(m.getG7());
			mt.setProgramName(m.getGn7());
			mtList.add(mt);
			mt = new MonitorTcp();
			mt.setLocation("1");
			mt.setStain(m.getG1());
			mt.setProgramName(m.getGn1());
			mtList.add(mt);
			monitorListList.add(mtList);
			
			mtList = new ArrayList<MonitorTcp>();
			mt = new MonitorTcp();
			mt.setLocation("");
			mt.setStain("-1");
			mt.setProgramName("");
			mtList.add(mt);
			mt = new MonitorTcp();
			mt.setLocation("19");
			mt.setStain(m.getG19());
			mt.setProgramName(m.getGn19());
			mtList.add(mt);
			mt = new MonitorTcp();
			mt.setLocation("14");
			mt.setStain(m.getG14());
			mt.setProgramName(m.getGn14());
			mtList.add(mt);
			mt = new MonitorTcp();
			mt.setLocation("8");
			mt.setStain(m.getG8());
			mt.setProgramName(m.getGn8());
			mtList.add(mt);
			mt = new MonitorTcp();
			mt.setLocation("2");
			mt.setStain(m.getG2());
			mt.setProgramName(m.getGn2());
			mtList.add(mt);
			monitorListList.add(mtList);
			
			mtList = new ArrayList<MonitorTcp>();
			mt = new MonitorTcp();
			mt.setLocation("24");
			mt.setStain(m.getG24());
			mt.setProgramName(m.getGn24());
			mtList.add(mt);
			mt = new MonitorTcp();
			mt.setLocation("20");
			mt.setStain(m.getG20());
			mt.setProgramName(m.getGn20());
			mtList.add(mt);
			mt = new MonitorTcp();
			mt.setLocation("15");
			mt.setStain(m.getG15());
			mt.setProgramName(m.getGn15());
			mtList.add(mt);
			mt = new MonitorTcp();
			mt.setLocation("9");
			mt.setStain(m.getG9());
			mt.setProgramName(m.getGn9());
			mtList.add(mt);
			mt = new MonitorTcp();
			mt.setLocation("3");
			mt.setStain(m.getG3());
			mt.setProgramName(m.getGn3());
			mtList.add(mt);
			monitorListList.add(mtList);
			
			mtList = new ArrayList<MonitorTcp>();
			mt = new MonitorTcp();
			mt.setLocation("25");
			mt.setStain(m.getG25());
			mt.setProgramName(m.getGn25());
			mtList.add(mt);
			mt = new MonitorTcp();
			mt.setLocation("21");
			mt.setStain(m.getG21());
			mt.setProgramName(m.getGn21());
			mtList.add(mt);
			mt = new MonitorTcp();
			mt.setLocation("16");
			mt.setStain(m.getG16());
			mt.setProgramName(m.getGn16());
			mtList.add(mt);
			mt = new MonitorTcp();
			mt.setLocation("10");
			mt.setStain(m.getG10());
			mt.setProgramName(m.getGn10());
			mtList.add(mt);
			mt = new MonitorTcp();
			mt.setLocation("4");
			mt.setStain(m.getG3());
			mt.setProgramName(m.getGn4());
			mtList.add(mt);
			monitorListList.add(mtList);
			
			mtList = new ArrayList<MonitorTcp>();
			mt = new MonitorTcp();
			mt.setLocation("26");
			mt.setStain(m.getG26());
			mt.setProgramName(m.getGn26());
			mtList.add(mt);
			mt = new MonitorTcp();
			mt.setLocation("22");
			mt.setStain(m.getG22());
			mt.setProgramName(m.getGn22());
			mtList.add(mt);
			mt = new MonitorTcp();
			mt.setLocation("17");
			mt.setStain(m.getG17());
			mt.setProgramName(m.getGn17());
			mtList.add(mt);
			mt = new MonitorTcp();
			mt.setLocation("11");
			mt.setStain(m.getG11());
			mt.setProgramName(m.getGn11());
			mtList.add(mt);
			mt = new MonitorTcp();
			mt.setLocation("5");
			mt.setStain(m.getG5());
			mt.setProgramName(m.getGn5());
			mtList.add(mt);
			monitorListList.add(mtList);
			
			mtList = new ArrayList<MonitorTcp>();
			mt = new MonitorTcp();
			mt.setLocation("27");
			mt.setStain(m.getG27());
			mt.setProgramName(m.getGn27());
			mtList.add(mt);
			mt = new MonitorTcp();
			mt.setLocation("23");
			mt.setStain(m.getG23());
			mt.setProgramName(m.getGn23());
			mtList.add(mt);
			mt = new MonitorTcp();
			mt.setLocation("18");
			mt.setStain(m.getG18());
			mt.setProgramName(m.getGn18());
			mtList.add(mt);
			mt = new MonitorTcp();
			mt.setLocation("12");
			mt.setStain(m.getG12());
			mt.setProgramName(m.getGn12());
			mtList.add(mt);
			mt = new MonitorTcp();
			mt.setLocation("6");
			mt.setStain(m.getG6());
			mt.setProgramName(m.getGn6());
			mtList.add(mt);
			monitorListList.add(mtList);
		}
		if(cw>=0) {//显示32个
			mtList = new ArrayList<MonitorTcp>();
			mt = new MonitorTcp();
			mt.setLocation("8");
			mt.setStain(m.getG8());
			mt.setProgramName(m.getGn8());
			mtList.add(mt);
			mt = new MonitorTcp();
			mt.setLocation("7");
			mt.setStain(m.getG7());
			mt.setProgramName(m.getGn7());
			mtList.add(mt);
			mt = new MonitorTcp();
			mt.setLocation("6");
			mt.setStain(m.getG6());
			mt.setProgramName(m.getGn6());
			mtList.add(mt);
			mt = new MonitorTcp();
			mt.setLocation("5");
			mt.setStain(m.getG5());
			mt.setProgramName(m.getGn5());
			mtList.add(mt);
			mt = new MonitorTcp();
			mt.setLocation("4");
			mt.setStain(m.getG4());
			mt.setProgramName(m.getGn4());
			mtList.add(mt);
			mt = new MonitorTcp();
			mt.setLocation("3");
			mt.setStain(m.getG3());
			mt.setProgramName(m.getGn3());
			mtList.add(mt);
			mt = new MonitorTcp();
			mt.setLocation("2");
			mt.setStain(m.getG2());
			mt.setProgramName(m.getGn2());
			mtList.add(mt);
			mt = new MonitorTcp();
			mt.setLocation("1");
			mt.setStain(m.getG1());
			mt.setProgramName(m.getGn1());
			mtList.add(mt);
			monitorListList.add(mtList);
			
			mtList = new ArrayList<MonitorTcp>();
			mt = new MonitorTcp();
			mt.setLocation("16");
			mt.setStain(m.getG16());
			mt.setProgramName(m.getGn16());
			mtList.add(mt);
			mt = new MonitorTcp();
			mt.setLocation("15");
			mt.setStain(m.getG15());
			mt.setProgramName(m.getGn15());
			mtList.add(mt);
			mt = new MonitorTcp();
			mt.setLocation("14");
			mt.setStain(m.getG14());
			mt.setProgramName(m.getGn14());
			mtList.add(mt);
			mt = new MonitorTcp();
			mt.setLocation("13");
			mt.setStain(m.getG13());
			mt.setProgramName(m.getGn13());
			mtList.add(mt);
			mt = new MonitorTcp();
			mt.setLocation("12");
			mt.setStain(m.getG12());
			mt.setProgramName(m.getGn12());
			mtList.add(mt);
			mt = new MonitorTcp();
			mt.setLocation("11");
			mt.setStain(m.getG11());
			mt.setProgramName(m.getGn11());
			mtList.add(mt);
			mt = new MonitorTcp();
			mt.setLocation("10");
			mt.setStain(m.getG10());
			mt.setProgramName(m.getGn10());
			mtList.add(mt);
			mt = new MonitorTcp();
			mt.setLocation("9");
			mt.setStain(m.getG9());
			mt.setProgramName(m.getGn9());
			mtList.add(mt);
			monitorListList.add(mtList);
			
			mtList = new ArrayList<MonitorTcp>();
			mt = new MonitorTcp();
			mt.setLocation("24");
			mt.setStain(m.getG24());
			mt.setProgramName(m.getGn24());
			mtList.add(mt);
			mt = new MonitorTcp();
			mt.setLocation("23");
			mt.setStain(m.getG23());
			mt.setProgramName(m.getGn23());
			mtList.add(mt);
			mt = new MonitorTcp();
			mt.setLocation("22");
			mt.setStain(m.getG22());
			mt.setProgramName(m.getGn22());
			mtList.add(mt);
			mt = new MonitorTcp();
			mt.setLocation("21");
			mt.setStain(m.getG21());
			mt.setProgramName(m.getGn21());
			mtList.add(mt);
			mt = new MonitorTcp();
			mt.setLocation("20");
			mt.setStain(m.getG20());
			mt.setProgramName(m.getGn20());
			mtList.add(mt);
			mt = new MonitorTcp();
			mt.setLocation("19");
			mt.setStain(m.getG19());
			mt.setProgramName(m.getGn19());
			mtList.add(mt);
			mt = new MonitorTcp();
			mt.setLocation("18");
			mt.setStain(m.getG18());
			mt.setProgramName(m.getGn18());
			mtList.add(mt);
			mt = new MonitorTcp();
			mt.setLocation("17");
			mt.setStain(m.getG17());
			mt.setProgramName(m.getGn17());
			mtList.add(mt);
			monitorListList.add(mtList);
			
			mtList = new ArrayList<MonitorTcp>();
			mt = new MonitorTcp();
			mt.setLocation("32");
			mt.setStain(m.getG32());
			mt.setProgramName(m.getGn32());
			mtList.add(mt);
			mt = new MonitorTcp();
			mt.setLocation("31");
			mt.setStain(m.getG31());
			mt.setProgramName(m.getGn31());
			mtList.add(mt);
			mt = new MonitorTcp();
			mt.setLocation("30");
			mt.setStain(m.getG30());
			mt.setProgramName(m.getGn30());
			mtList.add(mt);
			mt = new MonitorTcp();
			mt.setLocation("29");
			mt.setStain(m.getG29());
			mt.setProgramName(m.getGn29());
			mtList.add(mt);
			mt = new MonitorTcp();
			mt.setLocation("28");
			mt.setStain(m.getG28());
			mt.setProgramName(m.getGn28());
			mtList.add(mt);
			mt = new MonitorTcp();
			mt.setLocation("27");
			mt.setStain(m.getG27());
			mt.setProgramName(m.getGn27());
			mtList.add(mt);
			mt = new MonitorTcp();
			mt.setLocation("26");
			mt.setStain(m.getG26());
			mt.setProgramName(m.getGn26());
			mtList.add(mt);
			mt = new MonitorTcp();
			mt.setLocation("25");
			mt.setStain(m.getG25());
			mt.setProgramName(m.getGn25());
			mtList.add(mt);
			monitorListList.add(mtList);
		}
		return monitorListList;
	}
	/*
	 * 根据运行记录显示监控数据
	 */
	private Monitor getMonitorForRun(Monitor mm, List<Run> runList) {
		mm.setGn1("");
		mm.setGn2("");
		mm.setGn3("");
		mm.setGn4("");
		mm.setGn5("");
		mm.setGn6("");
		mm.setGn7("");
		mm.setGn8("");
		mm.setGn9("");
		mm.setGn10("");
		mm.setGn11("");
		mm.setGn12("");
		mm.setGn13("");
		mm.setGn14("");
		mm.setGn15("");
		mm.setGn16("");
		mm.setGn17("");
		mm.setGn18("");
		mm.setGn19("");
		mm.setGn20("");
		mm.setGn21("");
		mm.setGn22("");
		mm.setGn23("");
		mm.setGn24("");
		mm.setGn25("");
		mm.setGn26("");
		mm.setGn27("");
		mm.setGn28("");
		mm.setGn29("");
		mm.setGn30("");
		mm.setGn31("");
		mm.setGn32("");
		for(Run r:runList) {
			String siteLocation = r.getSiteLocation();
			if(siteLocation.equals("01"))
				mm.setGn1(r.getProgramName());
			else if(siteLocation.equals("02"))
				mm.setGn2(r.getProgramName());
			else if(siteLocation.equals("03"))
				mm.setGn3(r.getProgramName());
			else if(siteLocation.equals("04"))
				mm.setGn4(r.getProgramName());
			else if(siteLocation.equals("05"))
				mm.setGn5(r.getProgramName());
			else if(siteLocation.equals("06"))
				mm.setGn6(r.getProgramName());
			else if(siteLocation.equals("07"))
				mm.setGn7(r.getProgramName());
			else if(siteLocation.equals("08"))
				mm.setGn8(r.getProgramName());
			else if(siteLocation.equals("09"))
				mm.setGn9(r.getProgramName());
			else if(siteLocation.equals("10"))
				mm.setGn10(r.getProgramName());
			else if(siteLocation.equals("11"))
				mm.setGn11(r.getProgramName());
			else if(siteLocation.equals("12"))
				mm.setGn12(r.getProgramName());
			else if(siteLocation.equals("13"))
				mm.setGn13(r.getProgramName());
			else if(siteLocation.equals("14"))
				mm.setGn14(r.getProgramName());
			else if(siteLocation.equals("15"))
				mm.setGn15(r.getProgramName());
			else if(siteLocation.equals("16"))
				mm.setGn16(r.getProgramName());
			else if(siteLocation.equals("17"))
				mm.setGn17(r.getProgramName());
			else if(siteLocation.equals("18"))
				mm.setGn18(r.getProgramName());
			else if(siteLocation.equals("19"))
				mm.setGn19(r.getProgramName());
			else if(siteLocation.equals("20"))
				mm.setGn20(r.getProgramName());
			else if(siteLocation.equals("21"))
				mm.setGn21(r.getProgramName());
			else if(siteLocation.equals("22"))
				mm.setGn22(r.getProgramName());
			else if(siteLocation.equals("23"))
				mm.setGn23(r.getProgramName());
			else if(siteLocation.equals("24"))
				mm.setGn24(r.getProgramName());
			else if(siteLocation.equals("25"))
				mm.setGn25(r.getProgramName());
			else if(siteLocation.equals("26"))
				mm.setGn26(r.getProgramName());
			else if(siteLocation.equals("27"))
				mm.setGn27(r.getProgramName());
			else if(siteLocation.equals("28"))
				mm.setGn28(r.getProgramName());
			else if(siteLocation.equals("29"))
				mm.setGn29(r.getProgramName());
			else if(siteLocation.equals("30"))
				mm.setGn30(r.getProgramName());
			else if(siteLocation.equals("31"))
				mm.setGn31(r.getProgramName());
			else if(siteLocation.equals("32"))
				mm.setGn32(r.getProgramName());
			
		}
		return mm;
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
