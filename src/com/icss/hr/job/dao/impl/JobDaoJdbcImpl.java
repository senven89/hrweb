package com.icss.hr.job.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.icss.hr.common.DBUtil;
import com.icss.hr.job.dao.JobDao;
import com.icss.hr.job.vo.Job;

public class JobDaoJdbcImpl implements JobDao{

	public void delete(Job job) throws Exception {
		Connection conn = null;
		PreparedStatement pst = null;
		try {
			StringBuilder sb = new StringBuilder();
			sb.append("DELETE JOBS ");
			sb.append("WHERE job_id=?  ");

			conn = DBUtil.getConnection();
			pst = conn.prepareStatement(sb.toString());
			// ////////////////////////////////////////
			pst.setString(1, job.getJobId());
			// ////////////////////////////////////////
			pst.executeUpdate();
		} catch (Exception ex) {
			ex.printStackTrace();
			throw ex;
		} finally {
			DBUtil.close(null, pst, conn);
		}
	}

	public void insert(Job job) throws Exception {
		Connection conn = null;
		PreparedStatement pst = null;
		try {
			StringBuilder sb = new StringBuilder();
			sb.append("INSERT INTO JOBS ");
			sb.append("VALUES(?,?,?,?) ");

			conn = DBUtil.getConnection();
			pst = conn.prepareStatement(sb.toString());
			// ////////////////////////////////////////
			pst.setString(1, job.getJobId());
			pst.setString(2, job.getJobTitle());
			pst.setInt(3, job.getMinSal());
			pst.setInt(4, job.getMaxSal());
			// ////////////////////////////////////////
			pst.executeUpdate();
		} catch (Exception ex) {
			ex.printStackTrace();
			throw ex;         
		} finally {
			DBUtil.close(null, pst, conn);
		}
	}

	public List<Job> queryAll() throws Exception {
		List<Job> list = new ArrayList<Job>();
		Connection conn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		try {
			StringBuilder sb = new StringBuilder();
			sb.append(" SELECT  job_id ,  ");
			sb.append(" 		job_title ,  ");
			sb.append(" 		min_salary ,  ");
			sb.append(" 		max_salary   ");
			sb.append("FROM JOBS  ");

			conn = DBUtil.getConnection();
			pst = conn.prepareStatement(sb.toString());
			// ////////////////////////////////////////
			rs = pst.executeQuery();
			while (rs.next()) {
				String jobid = rs.getString(1);
				String jobtitle = rs.getString(2);
				int min = rs.getInt(3);
				int max = rs.getInt(4);
				

				Job job = new Job(jobid,jobtitle, min, max);
				list.add(job);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			throw ex;
		} finally {
			DBUtil.close(rs, pst, conn);
		}
		return list;
	}

	public Job queryById(String id) throws Exception {
		Job job = null;
		Connection conn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		try {
			StringBuilder sb = new StringBuilder();
			sb.append(" SELECT  job_id,  ");
			sb.append(" 		job_title,  ");
			sb.append(" 		min_salary ,  ");
			sb.append(" 		max_salary   ");
			sb.append("FROM JOBS  ");
			sb.append("WHERE  job_id = ?  ");

			conn = DBUtil.getConnection();
			pst = conn.prepareStatement(sb.toString());
			// ////////////////////////////////////////
			pst.setString(1, id);
			// ////////////////////////////////////////
			rs = pst.executeQuery();
			if (rs.next()) {
				String jobid = rs.getString(1);
				String jobtitle = rs.getString(2);
				int min = rs.getInt(3);
				int max = rs.getInt(4);
				

				job = new Job(jobid,jobtitle, min, max);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			throw ex;
		} finally {
			DBUtil.close(rs, pst, conn);
		}
		return job;
	}

	public void update(Job job) throws Exception {
		Connection conn = null;
		PreparedStatement pst = null;
		try {
			StringBuilder sb = new StringBuilder();
			sb.append("UPDATE JOBS ");
			sb.append("SET  job_title=?, ");
			sb.append(" 	min_salary=?, ");
			sb.append(" 	max_salary=? ");
			sb.append("WHERE job_id=?");

			conn = DBUtil.getConnection();
			pst = conn.prepareStatement(sb.toString());
			// ////////////////////////////////////////
			pst.setString(4, job.getJobId());
			pst.setString(1, job.getJobTitle());
			pst.setInt(2,job.getMinSal() );
			pst.setInt(3,job.getMaxSal() );
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
