package com.wenxr.iot.user.service.impl;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Repository;

import com.wenxr.iot.core.BaseService;
import com.wenxr.iot.core.PageValueObject;
import com.wenxr.iot.model.Role;
import com.wenxr.iot.model.User;
import com.wenxr.iot.user.service.IUserService;
import com.wenxr.iot.util.MD5;
import com.wenxr.iot.util.Tools;

@Repository
public class UserServiceImpl extends BaseService implements IUserService {

	public void saveUser(User user) {
		// 如果用户id为空，则为新增用户，调用addObject方法；否则是编辑用户，调用updateObject方法
		if (StringUtils.isEmpty(user.getUserId())) {
			commonDao.addObject(user);
		} else {
			commonDao.updateObject(user);
		}
	}

	public User getUserById(String id) {

		return commonDao.getObject(User.class, id);
	}

	public String deleteUserById(String id) {
		commonDao.delObject(User.class, id);
		return "删除成功！";
	}

	public List<Role> getAllRole() {
		String hql = "from Role r order by r.roleId";
		List<Role> roles = commonDao.getObjects(hql);
		return roles;
	}

	public void updateResetPsw(String userId) {
		String password = MD5.getMD5("1");
		String sql = "update user set password=? where user_id=?";
		commonDao.executeJDBCSql(sql, new Object[] { password, userId });
	}

	public int selectUserByUserName(String userId, String userName) {
		if (!Tools.isEmpty(userId)) {
			User user = commonDao.getObject(User.class, userId);
			if (userName.equals(user.getUserName())) {
				return 0;
			}
		}
		String hql = "from User r where r.userName=?";
		List<User> userList = commonDao.getObjects(hql, new Object[] { userName });
		if (userList != null) {
			return userList.size();
		}
		return 0;
	}

	public void updatePsw(User user) {
		// TODO Auto-generated method stub
		commonDao.updateObject(user);
	}

	public Object findAllUser() {
		String hql = "FROM User where role.roleId='3'";
		return commonDao.getObjects(hql);
	}

	public List<Object> getAllUser(String userName,String name,PageValueObject pageVo) {

		String hql = "select u.userId,u.userName,u.name,u.role.name,u.status from User u where 1=1";
		if(!Tools.isEmpty(userName)) {
			hql = hql +" and u.userName like '%"+userName+"%'";
		}
		if(!Tools.isEmpty(name)) {
			hql = hql +" and u.name like '%"+name+"%'";
		}
		hql = hql + " order by u.name asc";
		return commonDao.getObjectsByPage(hql, pageVo);
	}

	public List<Object> getAllUserNoPage() {
		String hql = "select u.userId,u.name from User u order by u.name asc";
		return commonDao.getObjects(hql);
	}

}
