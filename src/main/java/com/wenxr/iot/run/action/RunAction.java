package com.wenxr.iot.run.action;

import javax.annotation.Resource;

import com.wenxr.iot.core.BaseAction;
import com.wenxr.iot.core.PageValueObject;
import com.wenxr.iot.model.User;
import com.wenxr.iot.run.service.IRunService;
import com.wenxr.iot.util.Globals;
import com.wenxr.iot.util.Tools;
/**
 * 运行数据处理
 * @author Administrator
 *
 */
public class RunAction extends BaseAction {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Resource
	private IRunService runService;
	/**
	 * 分页查询所有记录
	 * @return
	 */
	public String loadAllRun() {
		User user = Globals.getLoginInfoBean(request.getSession());
		if (user == null) {
			return failure("登录超时，请重新登录！");
		}
		String roleId = user.getRole().getRoleId();
		String userCode;
		if(roleId.equals("1")) {//管理员
			userCode = request.getParameter("userCode");
		}else {
			userCode = user.getUserName();
		}
		String equipmentCode = request.getParameter("equipmentCode");
		String shelfId = request.getParameter("shelfId");
		String programName = request.getParameter("programName");
		this.data = new Object[] {runService.getAllRun(userCode,equipmentCode,shelfId,programName,pageVo), pageVo };
		return this.success();
	}
	/**
	 * 分页查询所有记录
	 * @return
	 */
	public String loadAllRunByEquipmentCode() {
		pageVo = new PageValueObject();
		String userCode = request.getParameter("userCode");
		String equipmentCode = request.getParameter("equipmentCode");
		if(Tools.isEmpty(userCode)||Tools.isEmpty(equipmentCode)) {
			return this.failure("程序异常！");
		}
		String pageNumber = request.getParameter("pageNumber");
		int start = (Integer.valueOf(Tools.isEmpty(pageNumber)?"1":pageNumber)-1)*pageVo.getTotal();
		pageVo.setStart(start);
		this.data = new Object[] {runService.getAllRunByEquipmentCode(userCode,equipmentCode,pageVo), pageVo };
		return this.success();
	}
	
}
