package com.wenxr.iot.history.action;

import javax.annotation.Resource;

import com.wenxr.iot.core.BaseAction;
import com.wenxr.iot.core.PageValueObject;
import com.wenxr.iot.history.service.IHistoryService;
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
		String equipmentCode = request.getParameter("equipmentCode");
		if(!user.getRole().getRoleId().equals("1")) {//非管理员
			userCode = user.getUserName();
		}
		this.data = new Object[] {historyService.getAllHistory(userCode,equipmentCode,pageVo), pageVo };
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
	
}
