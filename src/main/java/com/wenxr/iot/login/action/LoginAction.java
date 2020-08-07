package com.wenxr.iot.login.action;

import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;

import com.wenxr.iot.core.BaseAction;
import com.wenxr.iot.login.service.ILoginService;
import com.wenxr.iot.model.User;
import com.wenxr.iot.util.Globals;
import com.wenxr.iot.util.MD5;

public class LoginAction extends BaseAction {
	private static final long serialVersionUID = 1L;
	@Resource
	private ILoginService loginService;

	public String login() {
		this.definedReturnResult="/index.jsp";
		String userName = request.getParameter("userName");
		List<User> list = loginService.getUserByUserName(userName);
		User user = list.get(0);
		this.definedReturnResult="/indexFrame.jsp";
		this.data=user;
		request.getSession().setAttribute(Globals.getProp("LOGIN_INFO_BEAN"), user);
		return "DEFINED_REDIRECT";
	}
	public String checkLogin(){
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");
		if (StringUtils.isEmpty(userName)) {
			return failure("请输入用户名");
		}
		if (StringUtils.isEmpty(password)) {
			return failure("请输入密码");
		}
		List<User> list = loginService.getUserByUserName(userName);
		if (list.size() <= 0) {
			return failure("用户名不存在");
		} else {
			User user = list.get(0);
			
			try {
				if (!MD5.isMached(password, user.getPassword())) {
					return failure("用户名或密码错误");
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			if(user.getStatus().equals("禁用"))//离职
			{
				return failure("用户处于禁用状态，无法登录！");
			}
		}
		User user = list.get(0);
		this.data=user.getUserId();
		return success();
	}
	/**
	 * 用户注销
	 * @return
	 */
	public String logout(){
		this.definedReturnResult="/indexFrame.jsp";
		request.setAttribute("logout", "yes");
		request.getSession().removeAttribute(Globals.getProp("LOGIN_INFO_BEAN"));
		return success();
	}
}
