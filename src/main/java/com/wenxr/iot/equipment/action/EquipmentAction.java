package com.wenxr.iot.equipment.action;

import javax.annotation.Resource;

import com.wenxr.iot.core.BaseAction;
import com.wenxr.iot.equipment.service.IEquipmentService;
import com.wenxr.iot.model.Equipment;
import com.wenxr.iot.model.User;
import com.wenxr.iot.util.Globals;

public class EquipmentAction extends BaseAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Equipment equipment;
	@Resource
	private IEquipmentService equipmentService;
	/**
	 * 分页查询所有记录
	 * @return
	 */
	public String loadAllEquipment() {
		User user = Globals.getLoginInfoBean(request.getSession());
		if (user == null) {
			return failure("登录超时，请重新登录！");
		}
		String equipmentName = request.getParameter("equipmentName1");
		String equipmentCode = request.getParameter("equipmentCode1");
		this.data = new Object[] {equipmentService.getAllEquipment(equipmentName,equipmentCode,pageVo), pageVo };
		return this.success();
	}
	/**
	 * 验证设备编号
	 * @return
	 */
	public String checkEquipmentCode() {
		String equipmentId = request.getParameter("equipmentId");
		String equipmentCode = request.getParameter("equipmentCode");
		int count = equipmentService.selectEquipmentByEquipmentCode(equipmentId,equipmentCode);
		return success(String.valueOf(count));
	}
	/**
	 * 保存设备编号
	 * @return
	 */
	public String saveEquipment() {
		equipmentService.saveEquipment(equipment);
		return this.success();
	}
	/**
	 * 根据id查询设备
	 * @return
	 */
	public String selectEquipmentById() {
		String equipmentId = request.getParameter("equipmentId");
		this.data = equipmentService.getEquipmentById(equipmentId);
		return this.success();
	}
	/**
	 * 删除设备
	 * @return
	 */
	public String deleteEquipment() {
		String equipmentId = request.getParameter("equipmentId");
		String message= equipmentService.deleteE(equipmentId);
		return success(message);
	}
	/**
	 * app查询设备
	 * @return
	 */
	public String selectEquipmentsByUserId() {
		String userId = request.getParameter("userId");
		this.data = equipmentService.selectEquipmentsByUserId(userId);
		return success();
	}
	public Equipment getEquipment() {
		return equipment;
	}
	public void setEquipment(Equipment equipment) {
		this.equipment = equipment;
	}
	
}
