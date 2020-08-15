package com.wenxr.iot.tcp.service.impl;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.wenxr.iot.core.BaseService;
import com.wenxr.iot.model.History;
import com.wenxr.iot.model.Log;
import com.wenxr.iot.model.Monitor;
import com.wenxr.iot.model.Run;
import com.wenxr.iot.tcp.service.ITcpService;

@Repository
public class TcpServiceImpl extends BaseService implements ITcpService {

	public void addOrUpdate(String message, String ipConfig) {
		// TODO Auto-generated method stub
		Date date = new Date();
		SimpleDateFormat dateformat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		String time = dateformat.format(date);
		Log log = new Log();
		log.setClientIp(ipConfig);
		log.setLogContent(message);
		log.setLogTime(time);

		System.out.println(message + "   " + ipConfig);
		String sls = message.substring(0, 1);// 判断是否已{开始
		int e = message.lastIndexOf("}");
		int l = message.length();// 判断是否已}结束
		if (sls.equals("{") && e == l - 1) {
			message = message.substring(1, l-1);
			message = message.replaceAll(";", "%");
			String m[] = message.split(",");
			if (m.length > 3) {
				String flag = m[0];
				String userCode = m[1];
				String equipmentCode = m[2];
				if (flag.equals("0")) {// 监控记录
					log.setLogType("监控");
					String hql = "from Monitor m where m.userCode=? and m.equipmentCode=?";
					List<Monitor> monitorList = commonDao.getObjects(hql, new Object[] { userCode, equipmentCode });
					Monitor monitor;
					if (monitorList != null && monitorList.size() == 1) {// 存在记录
						monitor = monitorList.get(0);
					} else {// 不存在新建
						monitor = new Monitor();
						monitor.setUserCode(userCode);
						monitor.setEquipmentCode(equipmentCode);
					}
					for (int i = 3; i < m.length; i++) {
						String s = m[i];
						String ss[] = s.split(":");
						if (ss.length == 2) {
							if (ss[0].equals("G1")) {
								monitor.setG1(ss[1]);
							}
							if (ss[0].equals("G2")) {
								monitor.setG2(ss[1]);
							}
							if (ss[0].equals("G3")) {
								monitor.setG3(ss[1]);
							}
							if (ss[0].equals("G4")) {
								monitor.setG4(ss[1]);
							}
							if (ss[0].equals("G5")) {
								monitor.setG5(ss[1]);
							}
							if (ss[0].equals("G6")) {
								monitor.setG6(ss[1]);
							}
							if (ss[0].equals("G7")) {
								monitor.setG7(ss[1]);
							}
							if (ss[0].equals("G8")) {
								monitor.setG8(ss[1]);
							}
							if (ss[0].equals("G9")) {
								monitor.setG9(ss[1]);
							}
							if (ss[0].equals("G10")) {
								monitor.setG10(ss[1]);
							}
							if (ss[0].equals("G11")) {
								monitor.setG11(ss[1]);
							}
							if (ss[0].equals("G12")) {
								monitor.setG12(ss[1]);
							}
							if (ss[0].equals("G13")) {
								monitor.setG13(ss[1]);
							}
							if (ss[0].equals("G14")) {
								monitor.setG14(ss[1]);
							}
							if (ss[0].equals("G15")) {
								monitor.setG15(ss[1]);
							}
							if (ss[0].equals("G16")) {
								monitor.setG16(ss[1]);
							}
							if (ss[0].equals("G17")) {
								monitor.setG17(ss[1]);
							}
							if (ss[0].equals("G18")) {
								monitor.setG18(ss[1]);
							}
							if (ss[0].equals("G19")) {
								monitor.setG19(ss[1]);
							}
							if (ss[0].equals("G20")) {
								monitor.setG20(ss[1]);
							}
							if (ss[0].equals("G21")) {
								monitor.setG21(ss[1]);
							}
							if (ss[0].equals("G22")) {
								monitor.setG22(ss[1]);
							}
							if (ss[0].equals("G23")) {
								monitor.setG23(ss[1]);
							}
							if (ss[0].equals("G24")) {
								monitor.setG24(ss[1]);
							}
							if (ss[0].equals("G25")) {
								monitor.setG25(ss[1]);
							}
							if (ss[0].equals("G26")) {
								monitor.setG26(ss[1]);
							}
							if (ss[0].equals("G27")) {
								monitor.setG27(ss[1]);
							}
							if (ss[0].equals("G28")) {
								monitor.setG28(ss[1]);
							}
							if (ss[0].equals("G29")) {
								monitor.setG29(ss[1]);
							}
							if (ss[0].equals("G30")) {
								monitor.setG30(ss[1]);
							}
							if (ss[0].equals("G31")) {
								monitor.setG31(ss[1]);
							}
							if (ss[0].equals("G32")) {
								monitor.setG32(ss[1]);
							}
							if (ss[0].equals("封片数量")) {
								monitor.setCoverNumber(ss[1]);
							}
						}

					}
					if (monitorList != null && monitorList.size() == 1) {// 存在记录
						commonDao.updateObject(monitor);
					} else {// 不存在新建
						commonDao.addObject(monitor);
					}
				} else if (flag.equals("1")) {// 运行记录
					String mm[] = message.split("\\}\\{");
					for(String ml:mm) {
						String ms[] = ml.split(",");
						if (ms.length == 9) {
							log.setLogType("运行");
							String hql = "from Run r where r.userCode=? and r.equipmentCode=? and r.siteLocation=?";
							List<Run> runList = commonDao.getObjects(hql, new Object[] { userCode, equipmentCode,ms[5] });
							Run run ;
							String hql1 = "from Monitor m where m.userCode=? and m.equipmentCode=?";
							List<Monitor> monitorList = commonDao.getObjects(hql1, new Object[] { userCode, equipmentCode });
							Monitor monitor;
							if (runList != null && runList.size() == 1) {// 存在记录
								run = runList.get(0);
							} else {// 不存在新建
								run = new Run();
								run.setUserCode(userCode);
								run.setEquipmentCode(equipmentCode);
								run.setSiteLocation(ms[5]);
							}
							if (monitorList != null && monitorList.size() == 1) {// 存在记录
								monitor = monitorList.get(0);
							} else {// 不存在新建
								monitor = new Monitor();
								monitor.setUserCode(userCode);
								monitor.setEquipmentCode(equipmentCode);
							}
							run.setShelfId(ms[3]);
							run.setProgramName(ms[4]);
							run.setStepTime(ms[6]);
							run.setTotalTime(ms[7]);
							if(ms[5].equals("01"))
								monitor.setGn1(ms[4]);
							if(ms[5].equals("02"))
								monitor.setGn2(ms[4]);
							if(ms[5].equals("03"))
								monitor.setGn3(ms[4]);
							if(ms[5].equals("04"))
								monitor.setGn4(ms[4]);
							if(ms[5].equals("05"))
								monitor.setGn5(ms[4]);
							if(ms[5].equals("06"))
								monitor.setGn6(ms[4]);
							if(ms[5].equals("07"))
								monitor.setGn7(ms[4]);
							if(ms[5].equals("08"))
								monitor.setGn8(ms[4]);
							if(ms[5].equals("09"))
								monitor.setGn9(ms[4]);
							if(ms[5].equals("10"))
								monitor.setGn10(ms[4]);
							if(ms[5].equals("11"))
								monitor.setGn11(ms[4]);
							if(ms[5].equals("12"))
								monitor.setGn12(ms[4]);
							if(ms[5].equals("13"))
								monitor.setGn13(ms[4]);
							if(ms[5].equals("14"))
								monitor.setGn14(ms[4]);
							if(ms[5].equals("15"))
								monitor.setGn15(ms[4]);
							if(ms[5].equals("16"))
								monitor.setGn16(ms[4]);
							if(ms[5].equals("17"))
								monitor.setGn17(ms[4]);
							if(ms[5].equals("18"))
								monitor.setGn18(ms[4]);
							if(ms[5].equals("19"))
								monitor.setGn19(ms[4]);
							if(ms[5].equals("20"))
								monitor.setGn20(ms[4]);
							if(ms[5].equals("21"))
								monitor.setGn21(ms[4]);
							if(ms[5].equals("22"))
								monitor.setGn22(ms[4]);
							if(ms[5].equals("23"))
								monitor.setGn23(ms[4]);
							if(ms[5].equals("24"))
								monitor.setGn24(ms[4]);
							if(ms[5].equals("25"))
								monitor.setGn25(ms[4]);
							if(ms[5].equals("26"))
								monitor.setGn26(ms[4]);
							if(ms[5].equals("27"))
								monitor.setGn27(ms[4]);
							if(ms[5].equals("28"))
								monitor.setGn28(ms[4]);
							if(ms[5].equals("29"))
								monitor.setGn29(ms[4]);
							if(ms[5].equals("30"))
								monitor.setGn30(ms[4]);
							if(ms[5].equals("31"))
								monitor.setGn31(ms[4]);
							if(ms[5].equals("32"))
								monitor.setGn32(ms[4]);
							if (runList != null && runList.size() == 1) {// 存在记录
								commonDao.updateObject(run);
							} else {// 不存在新建
								commonDao.addObject(run);
							}
							if (monitorList != null && monitorList.size() == 1) {// 存在记录
								commonDao.updateObject(monitor);
							} else {// 不存在新建
								commonDao.addObject(monitor);
							}
						} else {
							log.setLogType("异常");
						}
					}
					

				} else if (flag.equals("2")) {// 历史记录
					if (m.length == 6) {
						log.setLogType("历史");
						String productionDate = m[5];
						String hql = "from History h where h.userCode=? and h.equipmentCode=? and h.productionDate=?";
						List<History> historyList = commonDao.getObjects(hql,
								new Object[] { userCode, equipmentCode, productionDate });
						History history;
						if (historyList != null && historyList.size() == 1) {// 存在记录
							history = historyList.get(0);
						} else {// 不存在新建
							history = new History();
							history.setUserCode(userCode);
							history.setEquipmentCode(equipmentCode);
							history.setProductionDate(productionDate);
						}
						history.setCoverNumber(m[3]);
						history.setDyeNumber(m[4]);
						if (historyList != null && historyList.size() == 1) {// 存在记录
							commonDao.updateObject(history);
						} else {// 不存在新建
							commonDao.addObject(history);
						}
					} else {
						log.setLogType("异常");
					}
				}
			} else {
				log.setLogType("异常");
			}
		}else {
			log.setLogType("异常");
		}

		commonDao.addObject(log);
	}

}
