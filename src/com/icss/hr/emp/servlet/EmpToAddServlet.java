package com.icss.hr.emp.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.icss.hr.dept.service.DeptService;
import com.icss.hr.dept.service.impl.DeptServiceImpl;
import com.icss.hr.dept.vo.Dept;
import com.icss.hr.job.service.JobService;
import com.icss.hr.job.service.impl.JobServiceImpl;
import com.icss.hr.job.vo.Job;

public class EmpToAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private JobService jobService = new JobServiceImpl();
	private DeptService deptService = new DeptServiceImpl();
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try{
			List<Job> jobList = jobService.queryAll();
			List<Dept> deptList = deptService.queryAll();
			
			request.setAttribute("jobList", jobList);
			request.setAttribute("deptList", deptList);
			request.getRequestDispatcher("/emp/empadd.jsp").forward(request, response);
		}catch(Exception ex){
			ex.printStackTrace();
			request.setAttribute("errormsg", ex.getMessage());
			request.getRequestDispatcher("/error.jsp").forward(request, response);
		}
	}

}
