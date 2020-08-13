package com.wenxr.iot.monitor.action;

import javax.annotation.Resource;

import com.wenxr.iot.core.BaseAction;
import com.wenxr.iot.model.User;
import com.wenxr.iot.monitor.service.IMonitorService;
import com.wenxr.iot.util.Globals;
import com.wenxr.iot.util.Tools;
/**
 * 监控数据处理
 * @author Administrator
 *
 */
public class MonitorAction extends BaseAction {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Resource
	private IMonitorService monitorService;
	/**
	 * 分页查询所有记录
	 * @return
	 */
	public String loadAllMonitor() {
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
		this.data = new Object[] {monitorService.getAllMonitor(userCode,equipmentCode,pageVo), pageVo };
		return this.success();
	}
	/**
	 * app查询一条记录
	 * @return
	 */
	public String loadMonitor() {
		String userCode = request.getParameter("userCode");
		String equipmentCode = request.getParameter("equipmentCode");
		if(Tools.isEmpty(userCode)||Tools.isEmpty(equipmentCode)) {
			return this.failure("程序异常！");
		}
		this.data=monitorService.getMonitor(userCode,equipmentCode);
		this.coverNumber = monitorService.getCoverNumber(userCode,equipmentCode);
		return this.success();
	}
}
