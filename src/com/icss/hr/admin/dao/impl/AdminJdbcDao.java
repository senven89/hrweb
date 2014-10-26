
package com.icss.hr.admin.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.icss.hr.admin.dao.AdminDao;
import com.icss.hr.admin.vo.Admin;
import com.icss.hr.common.DBUtil;

public class AdminJdbcDao implements AdminDao{
	public Admin queryById(String id)throws Exception{
		
	Admin admin=null;
	Connection conn=null;
	PreparedStatement pst=null;
	ResultSet rs = null;
	
		try{
			StringBuilder sb=new StringBuilder();
			sb.append("select adminname, ");
			sb.append("       adminpwd, ");
			sb.append("       adminlevel ");
			sb.append("FROM   ADMIN ");
			sb.append("WHERE  adminname=? ");
			
			conn = DBUtil.getConnection();
			pst = conn.prepareStatement(sb.toString());
			/////////////////////////////
			pst.setString(1, id);
			rs = pst.executeQuery();
			if (rs.next()) {
				String adminname=rs.getString(1);
				String adminpwd=rs.getString(2);
				int level=rs.getInt(3);
				admin=new Admin(adminname,adminpwd,level);
			}
		}catch(Exception e){
			e.printStackTrace();
			throw e;
		}finally{
			DBUtil.close(rs, pst, conn);
		}
		return admin;
	}

} 

	
