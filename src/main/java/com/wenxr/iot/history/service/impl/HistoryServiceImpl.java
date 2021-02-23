package com.wenxr.iot.history.service.impl;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Random;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.stereotype.Repository;

import com.wenxr.iot.core.BaseService;
import com.wenxr.iot.core.PageValueObject;
import com.wenxr.iot.history.service.IHistoryService;
import com.wenxr.iot.model.History;
import com.wenxr.iot.model.User;
import com.wenxr.iot.util.Tools;

@Repository
public class HistoryServiceImpl extends BaseService implements IHistoryService {

	public List<Object> getAllHistory(String userCode,String userCode1, String equipmentCode,String start,String end, PageValueObject pageVo) {
		String hql = "select h.userCode,h.equipmentCode,h.coverNumber,h.dyeNumber,h.productionDate from History h where 1=1";
		if (!Tools.isEmpty(userCode)) {
			hql = hql + " and h.userCode like '%" + userCode + "%'";
		}
		if (!Tools.isEmpty(userCode1)) {
			hql = hql + " and h.userCode='" + userCode1 + "'";
		}
		if (!Tools.isEmpty(equipmentCode)) {
			hql = hql + " and h.equipmentCode like '%" + equipmentCode + "%'";
		}
		if (!Tools.isEmpty(start)) {
			hql = hql + " and h.productionDate >= '" + start + "%'";
		}
		if (!Tools.isEmpty(end)) {
			hql = hql + " and h.productionDate <= '" + end + "%'";
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

	public List<History> getHistoryListByEquipmentCode(String equipmentCode,String userCode) {
		String hql = "FROM History h where 1=1 ";
		if(!Tools.isEmpty(equipmentCode)) {
			hql = hql + " and h.equipmentCode like '%" + equipmentCode + "%'";
		}
		if(!Tools.isEmpty(userCode)) {
			hql = hql + " and h.userCode = '" + userCode + "'";
		}
		hql = hql + " order by h.productionDate desc";
		return commonDao.getObjects(hql);
	}

	public Object exportExcel(List<History> list, Workbook wb, String fileName) {
		int path = fileName.lastIndexOf("/");
		String basePathImg = fileName.substring(0, path + 1);
		// 2.1、获取工作表
		Sheet sheet = wb.getSheetAt(0);
		// 3.1、创建行----表头行
		Row row = sheet.getRow(0);
		// 5、写入实体数据
		for (int i = 0; i < list.size(); i++) {
			// 3.2、创建行----内容行
			row = sheet.createRow(i + 1);
			History history = list.get(i);
			row.createCell(0).setCellValue(i + 1);
			String userCode = history.getUserCode();
			String hql = "From User u where u.userName=?";
			List<User> userList = commonDao.getObjects(hql, new Object[] {userCode});
			String userName = "";
			if(userList.size()==1) {
				userName = userList.get(0).getName();
			}
			row.createCell(1).setCellValue(userName);
			row.createCell(2).setCellValue(history.getCoverNumber());
			row.createCell(3).setCellValue(history.getDyeNumber());
			row.createCell(4).setCellValue(history.getProductionDate());
		}
		FileOutputStream fout;
		Date date = new Date();
		String nowDate = String.valueOf(date.getTime());
		Random random = new Random();
		String r = String.valueOf(random.nextInt(99));
		String filename = nowDate + r + ".xlsx";
		try {
			fout = new FileOutputStream(basePathImg + "/temporary/" + filename);
			wb.write(fout);
			fout.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return filename;
	}

	public Object getFengPianAndRanSe(String userCode, String equipmentCode, String start, String end) {
		String hql = "select sum(h.coverNumber),sum(h.dyeNumber) from History h where 1=1 ";
		if (!Tools.isEmpty(userCode)) {
			hql = hql + " and h.userCode like '%" + userCode + "%'";
		}
		if (!Tools.isEmpty(equipmentCode)) {
			hql = hql + " and h.equipmentCode like '%" + equipmentCode + "%'";
		}
		if (!Tools.isEmpty(start)) {
			hql = hql + " and h.productionDate >= '" + start + "%'";
		}
		if (!Tools.isEmpty(end)) {
			hql = hql + " and h.productionDate <= '" + end + "%'";
		}
		List<Object> l = commonDao.getObjects(hql);
		return l;
	}

}
