package com.icss.hr.dept.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.icss.hr.common.DBUtil;
import com.icss.hr.dept.dao.DeptDao;
import com.icss.hr.dept.vo.Dept;

public class DeptDaoJdbcImpl implements DeptDao{

	public void delete(Dept dept) throws Exception {
		Connection conn = null;
		PreparedStatement pst = null;
		try {
			StringBuilder sb = new StringBuilder();
			sb.append("DELETE DEPT ");
			sb.append("WHERE dept_id=?  ");

			conn = DBUtil.getConnection();
			pst = conn.prepareStatement(sb.toString());
			// ////////////////////////////////////////
			pst.setInt(1, dept.getDeptId());
			// ////////////////////////////////////////
			pst.executeUpdate();
		} catch (Exception ex) {
			ex.printStackTrace();
			throw ex;
		} finally {
			DBUtil.close(null, pst, conn);
		}
	}

	public void intsert(Dept dept) throws Exception {
		Connection conn = null;
		PreparedStatement pst = null;
		try {
			StringBuilder sb = new StringBuilder();
			sb.append("INSERT INTO DEPT ");
			sb.append("VALUES(?,?,?) ");

			conn = DBUtil.getConnection();
			pst = conn.prepareStatement(sb.toString());
			// ////////////////////////////////////////
			pst.setInt(1, dept.getDeptId());
			pst.setString(2, dept.getDeptName());
			pst.setString(3, dept.getDeptLoc());
			// ////////////////////////////////////////
			pst.executeUpdate();
		} catch (Exception ex) {
			ex.printStackTrace();
			throw ex;
		} finally {
			DBUtil.close(null, pst, conn);
		}
	}

	public List<Dept> queryAll() throws Exception {
		List<Dept> list = new ArrayList<Dept>();
		Connection conn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		try {
			StringBuilder sb = new StringBuilder();
			sb.append("SELECT	dept_id ,  ");
			sb.append(" 		dept_name ,  ");
			sb.append("     	dept_loc  ");
			sb.append("FROM DEPT   ");

			conn = DBUtil.getConnection();
			pst = conn.prepareStatement(sb.toString());
			// ////////////////////////////////////////
			rs = pst.executeQuery();
			while (rs.next()) {
				int deptid = rs.getInt(1);
				String deptname = rs.getString(2);
				String deptloc = rs.getString(3);

				Dept dept = new Dept(deptid, deptname,deptloc);
				list.add(dept);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			throw ex;
		} finally {
			DBUtil.close(rs, pst, conn);
		}
		return list;
	}

	public Dept queryById(int id) throws Exception {
		Dept dept = null;
		Connection conn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		try {
			StringBuilder sb = new StringBuilder();
			sb.append("SELECT	dept_id ,  ");
			sb.append(" 		dept_name ,  ");
			sb.append(" 		dept_loc  ");
			sb.append("FROM  DEPT  ");
			sb.append("WHERE  dept_id = ?  ");

			conn = DBUtil.getConnection();
			pst = conn.prepareStatement(sb.toString());
			// ////////////////////////////////////////
			pst.setInt(1, id);
			// ////////////////////////////////////////
			rs = pst.executeQuery();
			if (rs.next()) {
				int deptid = rs.getInt(1);
				String deptname = rs.getString(2);
				String deptloc = rs.getString(3);

				dept = new Dept(deptid, deptname,deptloc);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			throw ex;
		} finally {
			DBUtil.close(rs, pst, conn);
		}
		return dept;
	}

	public void update(Dept dept) throws Exception {
		Connection conn = null;
		PreparedStatement pst = null;
		try {
			StringBuilder sb = new StringBuilder();
			sb.append("UPDATE DEPT ");
			sb.append("SET	dept_name=?, ");
			sb.append(" 	dept_loc=? ");
			sb.append("WHERE dept_id=?");

			conn = DBUtil.getConnection();
			pst = conn.prepareStatement(sb.toString());
			// ////////////////////////////////////////
			
			pst.setString(1, dept.getDeptName());
			pst.setString(2, dept.getDeptLoc());
			pst.setInt(3, dept.getDeptId());
			// ////////////////////////////////////////
			pst.executeUpdate();
		} catch (Exception ex) {
			ex.printStackTrace();
			throw ex;
		} finally {
			DBUtil.close(null, pst, conn);
		}
	}

}
