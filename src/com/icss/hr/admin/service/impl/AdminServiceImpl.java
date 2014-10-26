package com.icss.hr.admin.service.impl;

import com.icss.hr.admin.dao.AdminDao;
import com.icss.hr.admin.dao.impl.AdminJdbcDao;
import com.icss.hr.admin.service.AdminService;
import com.icss.hr.admin.vo.Admin;

public class AdminServiceImpl implements AdminService {

	private AdminDao dao = new AdminJdbcDao();
	public int queryLogin(Admin uiAdmin) throws Exception {
		Admin dbAdmin = dao.queryById(uiAdmin.getAdminName());
		if(dbAdmin == null){
			return -1;
		}else if(!uiAdmin.getAdminPwd().equals(dbAdmin.getAdminPwd())){
			return -2;
		}else if(uiAdmin.getLevel()!= dbAdmin.getLevel()){
			return -3;
		}else{
			return 1;
		}
	}

}
