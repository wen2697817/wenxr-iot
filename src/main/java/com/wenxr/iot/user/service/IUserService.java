package com.wenxr.iot.user.service;

import java.util.List;

import com.wenxr.iot.core.PageValueObject;
import com.wenxr.iot.model.Role;
import com.wenxr.iot.model.User;


public interface IUserService {
	/**
	 * 保存用户信息
	 * 
	 * @param user
	 */
	public void saveUser(User user);

	/**
	 * 根据id获取用户对象
	 * 
	 * @param id
	 * @return
	 */
	public User getUserById(String id);

	/**
	 * 根据id删除用户
	 * 
	 * @param id
	 */
	public String deleteUserById(String id);
	/**
	 * 获得所有角色
	 * @return
	 */
	public List<Role> getAllRole();
	/**
	 * 重置密码
	 * @param userId
	 */
	public void updateResetPsw(String userId);
	/**
	 * 根据用户名查询用户个数
	 * @param userName
	 * @return
	 */
	public int selectUserByUserName(String userId,String userName);
	/**
	 * 更新密码
	 * @param user
	 */
	public void updatePsw(User user);
	/**
	 * 查询所有业务员
	 * @return
	 */
	public Object findAllUser();
	/**
	 * 分页查询所有用户
	 * @param pageVo
	 * @return
	 */
	public List<Object> getAllUser(String userName,String name,PageValueObject pageVo);
	/**
	 * 查询所有用户
	 * @return
	 */
	public List<Object> getAllUserNoPage();
}
