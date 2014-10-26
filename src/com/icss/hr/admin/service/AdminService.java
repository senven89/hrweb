package com.icss.hr.admin.service;

import com.icss.hr.admin.vo.Admin;

public interface AdminService {
	//1：登录成功
	//-1：用户名不存在
	//-2：密码不正确
	//-3权限有误
	public int queryLogin(Admin uiAdmin) throws Exception;
	

}
