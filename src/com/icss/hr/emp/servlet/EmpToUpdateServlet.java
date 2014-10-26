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
import com.icss.hr.emp.service.EmpService;
import com.icss.hr.emp.service.impl.EmpServiceImpl;
import com.icss.hr.emp.vo.Emp;
import com.icss.hr.job.service.JobService;
import com.icss.hr.job.service.impl.JobServiceImpl;
import com.icss.hr.job.vo.Job;

public class EmpToUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private JobService jobService = new JobServiceImpl();
	private EmpService service = new EmpServiceImpl();
	private DeptService deptService = new DeptServiceImpl();
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try{
			String EmpId = request.getParameter("EmpId");
			Emp emp = service.queryById(Integer.parseInt(EmpId));
			List<Job> jobList = jobService.queryAll();
			List<Dept> deptList = deptService.queryAll();
			
			request.setAttribute("jobList", jobList);
			request.setAttribute("deptList", deptList);
			request.setAttribute("Emp", emp);
			
			request.getRequestDispatcher("/emp/empupdate.jsp").forward(request, response);
		}catch(Exception ex){
			ex.printStackTrace();
			request.setAttribute("errormsg", ex.getMessage());
			request.getRequestDispatcher("/error.jsp").forward(request, response);
		}
	}

}
