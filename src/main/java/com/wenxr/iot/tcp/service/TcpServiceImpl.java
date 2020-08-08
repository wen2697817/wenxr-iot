package com.wenxr.iot.tcp.service;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.wenxr.iot.core.BaseService;
import com.wenxr.iot.model.History;
import com.wenxr.iot.model.Monitor;
import com.wenxr.iot.model.Run;
@Repository
public class TcpServiceImpl extends BaseService implements ITcpService {

	public void addOrUpdate(String message,String ipConfig) {
		// TODO Auto-generated method stub
		System.out.println(message+"   "+ipConfig);
		String m[] = message.split(",");
		if(m.length>3) {
			message = message.replaceAll(";", "%");
			String flag = m[0];
			String userCode = m[1];
			String equipmentCode = m[2];
			if(flag.equals("0")) {//监控记录
				String hql = "from Monitor m where m.userCode=? and m.equipmentCode=?";
				List<Monitor> monitorList = commonDao.getObjects(hql, new Object[] {userCode,equipmentCode});
				Monitor monitor;
				if(monitorList!=null&&monitorList.size()==1) {//存在记录
					monitor = monitorList.get(0);
				}else {//不存在新建
					monitor = new Monitor();
					monitor.setUserCode(userCode);
					monitor.setEquipmentCode(equipmentCode);
				}
				for(int i=3;i<m.length;i++) {
					String s = m[i];
					String ss[] = s.split(":");
					if(ss.length==2) {
						if(ss[0].equals("G1")) {
							monitor.setG1(ss[1]);
						}
						if(ss[0].equals("G2")) {
							monitor.setG2(ss[1]);
						}
						if(ss[0].equals("G3")) {
							monitor.setG3(ss[1]);
						}
						if(ss[0].equals("G4")) {
							monitor.setG4(ss[1]);
						}
						if(ss[0].equals("G5")) {
							monitor.setG5(ss[1]);
						}
						if(ss[0].equals("G6")) {
							monitor.setG6(ss[1]);
						}
						if(ss[0].equals("G7")) {
							monitor.setG7(ss[1]);
						}
						if(ss[0].equals("G8")) {
							monitor.setG8(ss[1]);
						}
						if(ss[0].equals("G9")) {
							monitor.setG9(ss[1]);
						}
						if(ss[0].equals("G10")) {
							monitor.setG10(ss[1]);
						}
						if(ss[0].equals("G11")) {
							monitor.setG11(ss[1]);
						}
						if(ss[0].equals("G12")) {
							monitor.setG12(ss[1]);
						}
						if(ss[0].equals("G13")) {
							monitor.setG13(ss[1]);
						}
						if(ss[0].equals("G14")) {
							monitor.setG14(ss[1]);
						}
						if(ss[0].equals("G15")) {
							monitor.setG15(ss[1]);
						}
						if(ss[0].equals("G16")) {
							monitor.setG16(ss[1]);
						}
						if(ss[0].equals("G17")) {
							monitor.setG17(ss[1]);
						}
						if(ss[0].equals("G18")) {
							monitor.setG18(ss[1]);
						}
						if(ss[0].equals("G19")) {
							monitor.setG19(ss[1]);
						}
						if(ss[0].equals("G20")) {
							monitor.setG20(ss[1]);
						}
						if(ss[0].equals("G21")) {
							monitor.setG21(ss[1]);
						}
						if(ss[0].equals("G22")) {
							monitor.setG22(ss[1]);
						}
						if(ss[0].equals("G23")) {
							monitor.setG23(ss[1]);
						}
						if(ss[0].equals("G24")) {
							monitor.setG24(ss[1]);
						}
						if(ss[0].equals("G25")) {
							monitor.setG25(ss[1]);
						}
						if(ss[0].equals("G26")) {
							monitor.setG26(ss[1]);
						}
						if(ss[0].equals("G27")) {
							monitor.setG27(ss[1]);
						}
						if(ss[0].equals("G28")) {
							monitor.setG28(ss[1]);
						}
						if(ss[0].equals("G29")) {
							monitor.setG29(ss[1]);
						}
						if(ss[0].equals("G30")) {
							monitor.setG30(ss[1]);
						}
						if(ss[0].equals("G31")) {
							monitor.setG31(ss[1]);
						}
						if(ss[0].equals("G32")) {
							monitor.setG32(ss[1]);
						}
						if(ss[0].equals("封片数量")) {
							monitor.setCoverNumber(ss[1]);
						}
					}
					
				}
				if(monitorList!=null&&monitorList.size()==1) {//存在记录
					commonDao.updateObject(monitor);
				}else {//不存在新建
					commonDao.addObject(monitor);
				}
			}else if(flag.equals("1")) {//运行记录
				message = message.replaceAll(";", "%");
				if(m.length==8) {
					Run run = new Run();
					run.setUserCode(userCode);
					run.setEquipmentCode(equipmentCode);
					run.setShelfId(m[3]);
					run.setProgramName(m[4]);
					run.setSiteLocation(m[5]);
					run.setStepTime(m[6]);
					run.setTotalTime(m[7]);
					commonDao.addObject(run);
				}
				
			}else if(flag.equals("2")) {//历史记录
				if(m.length==7) {
					String productionDate = m[6];
					String hql = "from History h where h.userCode=? and h.equipmentCode=? and h.productionDate=?";
					List<History> historyList = commonDao.getObjects(hql, new Object[] {userCode,equipmentCode,productionDate});
					History history;
					if(historyList!=null&&historyList.size()==1) {//存在记录
						history = historyList.get(0);
					}else {//不存在新建
						history = new History();
						history.setUserCode(userCode);
						history.setEquipmentCode(equipmentCode);
						history.setProductionDate(productionDate);
					}
					history.setCoverNumber(m[4]);
					history.setDyeNumber(m[5]);
					if(historyList!=null&&historyList.size()==1) {//存在记录
						commonDao.updateObject(history);
					}else {//不存在新建
						commonDao.addObject(history);
					}
				}
			}
		}
		
	}

}
