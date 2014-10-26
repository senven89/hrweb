package com.icss.hr.emp.dao.impl;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.icss.hr.common.DBUtil;
import com.icss.hr.dept.vo.Dept;
import com.icss.hr.emp.dao.EmpDao;
import com.icss.hr.emp.vo.Emp;
import com.icss.hr.job.vo.Job;

public class EmpDaoJdbcImpl implements EmpDao {

	public void intsert(Emp emp) throws Exception {
		Connection conn = null;
		PreparedStatement pst = null;
		try {
			StringBuilder sb = new StringBuilder();
			sb.append("INSERT INTO emp ");
			sb.append("VALUES(EMP_SEQ.nextval,?,?,?,?,?,?) ");

			conn = DBUtil.getConnection();
			pst = conn.prepareStatement(sb.toString());
			// ////////////////////////////////////////
			pst.setString(1, emp.getEname());
			pst.setString(2, emp.getEmail());
			pst.setDate(3, emp.getHiredate());
			pst.setString(4, emp.getJob().getJobId());
			pst.setBigDecimal(5, emp.getSal());
			pst.setInt(6, emp.getDept().getDeptId());
			// ////////////////////////////////////////
			pst.executeUpdate();
		} catch (Exception ex) {
			ex.printStackTrace();
			throw ex;
		} finally {
			DBUtil.close(null, pst, conn);
		}
	}

	public void update(Emp emp) throws Exception {
		Connection conn = null;
		PreparedStatement pst = null;
		try {
			StringBuilder sb = new StringBuilder();
			sb.append("UPDATE EMP ");
			sb.append("SET  dept_id=?, ");
			sb.append(" 	ename=?, ");
			sb.append(" 	email=?, ");
			sb.append(" 	hire_date =?, ");
			sb.append(" 	job_id=?, ");
			sb.append(" 	salary=? ");
			sb.append("WHERE emp_id=?");

			conn = DBUtil.getConnection();
			pst = conn.prepareStatement(sb.toString());
			// ////////////////////////////////////////
			pst.setInt(1, emp.getDept().getDeptId());
			pst.setString(2, emp.getEname());
			pst.setString(3, emp.getEmail());
			pst.setDate(4, emp.getHiredate());
			pst.setString(5, emp.getJob().getJobId());
			pst.setBigDecimal(6, emp.getSal());
			pst.setInt(7, emp.getEmpId());
			// ////////////////////////////////////////
			pst.executeUpdate();
		} catch (Exception ex) {
			ex.printStackTrace();
			throw ex;
		} finally {
			DBUtil.close(null, pst, conn);
		}
	}

	public void delete(Emp emp) throws Exception {
		Connection conn = null;
		PreparedStatement pst = null;
		try {
			StringBuilder sb = new StringBuilder();
			sb.append("DELETE EMP ");
			sb.append("WHERE emp_id=?  ");

			conn = DBUtil.getConnection();
			pst = conn.prepareStatement(sb.toString());
			// ////////////////////////////////////////
			pst.setInt(1, emp.getEmpId());
			// ////////////////////////////////////////
			pst.executeUpdate();
		} catch (Exception ex) {
			ex.printStackTrace();
			throw ex;
		} finally {
			DBUtil.close(null, pst, conn);
		}
	}

	public Emp queryById(int id) throws Exception {
		Emp emp = null;
		Connection conn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		try {
			StringBuilder sb = new StringBuilder();
			sb.append("SELECT 	e.emp_id ,  ");
			sb.append(" 	  	e.ename ,  ");
			sb.append(" 	  	e.email ,  ");
			sb.append(" 		e.hire_date ,  ");
			sb.append(" 		e.job_id ,  ");
			sb.append(" 		j.job_title ,  ");
			sb.append(" 		j.min_salary ,  ");
			sb.append(" 		j.max_salary ,  ");
			sb.append(" 		e.salary ,  ");
			sb.append(" 		e.dept_id ,  ");
			sb.append(" 		d.dept_name ,  ");
			sb.append(" 		d.dept_loc  ");
			sb.append("FROM EMP  e,  ");
			sb.append("     DEPT  d,  ");
			sb.append("     JOBS  j  ");
			sb.append("WHERE  e.emp_id = ?  ");
			sb.append("and  e.job_id = j.job_id  ");
			sb.append("and  e.dept_id = d.dept_id  ");

			conn = DBUtil.getConnection();
			pst = conn.prepareStatement(sb.toString());
			// ////////////////////////////////////////
			pst.setInt(1, id);
			// ////////////////////////////////////////
			rs = pst.executeQuery();
			if (rs.next()) {
				int empid = rs.getInt(1);
				String ename = rs.getString(2);
				String email = rs.getString(3);
				Date date = rs.getDate(4);
				String jobid = rs.getString(5);
				String jobtitle = rs.getString(6);
				int min = rs.getInt(7);
				int max = rs.getInt(8);
				BigDecimal salary = rs.getBigDecimal(9);
				int deptid = rs.getInt(10);
				String deptname = rs.getString(11);
				String deptloc = rs.getString(12);

				emp = new Emp(empid, ename, email, date, new Job(jobid,
						jobtitle, min, max), salary, new Dept(deptid, deptname,
						deptloc));
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			throw ex;
		} finally {
			DBUtil.close(rs, pst, conn);
		}
		return emp;
	}

	public List<Emp> queryAll() throws Exception {
		List<Emp> list = new ArrayList<Emp>();
		Connection conn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		try {
			StringBuilder sb = new StringBuilder();
			sb.append("SELECT 	e.emp_id ,  ");
			sb.append(" 	  	e.ename ,  ");
			sb.append(" 	  	e.email ,  ");
			sb.append(" 		e.hire_date ,  ");
			sb.append(" 		e.job_id ,  ");
			sb.append(" 		j.job_title ,  ");
			sb.append(" 		j.min_salary ,  ");
			sb.append(" 		j.max_salary ,  ");
			sb.append(" 		e.salary ,  ");
			sb.append(" 		e.dept_id ,  ");
			sb.append(" 		d.dept_name ,  ");
			sb.append(" 		d.dept_loc  ");
			sb.append("FROM EMP  e,  ");
			sb.append("     DEPT  d,  ");
			sb.append("     JOBS  j  ");
			sb.append("WHERE  e.job_id = j.job_id  ");
			sb.append("AND  e.dept_id = d.dept_id  ");

			conn = DBUtil.getConnection();
			pst = conn.prepareStatement(sb.toString());
			// ////////////////////////////////////////
			rs = pst.executeQuery();
			while (rs.next()) {
				int empid = rs.getInt(1);
				String ename = rs.getString(2);
				String email = rs.getString(3);
				Date date = rs.getDate(4);
				String jobid = rs.getString(5);
				String jobtitle = rs.getString(6);
				int min = rs.getInt(7);
				int max = rs.getInt(8);
				BigDecimal salary = rs.getBigDecimal(9);
				int deptid = rs.getInt(10);
				String deptname = rs.getString(11);
				String deptloc = rs.getString(12);

				Emp emp = new Emp(empid, ename, email, date, new Job(jobid,
						jobtitle, min, max), salary, new Dept(deptid, deptname,
						deptloc));
				list.add(emp);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			throw ex;
		} finally {
			DBUtil.close(rs, pst, conn);
		}
		return list;
	}
}
