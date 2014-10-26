package com.icss.hr.admin.dao;

import com.icss.hr.admin.vo.Admin;

public interface AdminDao {
	public Admin queryById(String id) throws Exception;

}
