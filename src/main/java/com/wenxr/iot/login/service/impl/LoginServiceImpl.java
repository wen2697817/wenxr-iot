package com.wenxr.iot.login.service.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.wenxr.iot.core.BaseService;
import com.wenxr.iot.login.service.ILoginService;
import com.wenxr.iot.model.User;

@Repository("loginService")
public class LoginServiceImpl extends BaseService implements ILoginService {

	public List<User> getUserByUserName(String userName) {
		String hql="from User where userName=?";
		return commonDao.getObjects(hql, new Object[]{userName});
	}
}
