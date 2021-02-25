package com.wenxr.iot.history.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import javax.annotation.Resource;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.wenxr.iot.core.BaseAction;
import com.wenxr.iot.core.PageValueObject;
import com.wenxr.iot.history.service.IHistoryService;
import com.wenxr.iot.model.History;
import com.wenxr.iot.model.User;
import com.wenxr.iot.util.Globals;
import com.wenxr.iot.util.Tools;

public class HistoryAction extends BaseAction {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Resource
	private IHistoryService historyService;
	String fileName = basePath + "\\img\\5bsb_double.jpg";
	/**
	 * 分页查询所有记录
	 * @return
	 */
	public String loadAllHistory() {
		User user = Globals.getLoginInfoBean(request.getSession());
		if (user == null) {
			return failure("登录超时，请重新登录！");
		}
		String userCode = request.getParameter("userCode");
		String userCode1 = request.getParameter("userCode1");
		String equipmentCode = request.getParameter("equipmentCode");
		String start = request.getParameter("createTimeStart");
		String end = request.getParameter("createTimeEnd");
		if(!user.getRole().getRoleId().equals("1")) {//非管理员
			userCode = user.getUserName();
		}
		this.data = new Object[] {historyService.getAllHistory(userCode,userCode1,equipmentCode,start,end,pageVo), pageVo,historyService.getFengPianAndRanSe(userCode1,equipmentCode,start,end)};
		return this.success();
	}
	/**
	 * app分页查询所有记录
	 * @return
	 */
	public String loadAllHistoryByCode() {
		pageVo = new PageValueObject();
		String userCode = request.getParameter("userCode");
		String equipmentCode = request.getParameter("equipmentCode");
		if(Tools.isEmpty(userCode)||Tools.isEmpty(equipmentCode)) {
			return this.failure("程序异常！参数有误");
		}
		String pageNumber = request.getParameter("pageNumber");
		int start = (Integer.valueOf(Tools.isEmpty(pageNumber)?"1":pageNumber)-1)*pageVo.getTotal();
		pageVo.setStart(start);
		this.data = new Object[] {historyService.getAllHistoryByCode(userCode,equipmentCode,pageVo), pageVo };
		return this.success();
	}
	/**
	 * 生成表格
	 * @return
	 */
	public String exportExcel() {
		User user = Globals.getLoginInfoBean(request.getSession());
		if (user == null) {
			return failure("登录超时，请重新登录！");
		}
		String userCode = "";
		if(user.getRole().getRoleId().equals("2")) {
			userCode = user.getUserName();
		}
		String equipmentCode = request.getParameter("equipmentCode");
		List<History> list = historyService.getHistoryListByEquipmentCode(equipmentCode,userCode);
		try {
			File file = new File("c:\\history.xlsx");
			InputStream in = new FileInputStream(file);
			Workbook wb = new XSSFWorkbook(in);
			this.data = new Object[] { historyService.exportExcel(list, wb,
					fileName.replace("\\", "/")) };
			in.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return this.success();
	}
	public String loadAllHistoryForWeChat() {
		String userCode = request.getParameter("userCode");
		String equipmentCode = request.getParameter("equipmentCode");
		String start = request.getParameter("startDate");
		String end = request.getParameter("endDate");
		return this.success();
		
	}
	/**
	 * 删除临时文件
	 * @return
	 */
	public String delTemporary() {
		return success();
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
}
