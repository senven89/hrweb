package com.icss.hr.emp.servlet;

import java.io.IOException;
import java.math.BigDecimal;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.icss.hr.dept.vo.Dept;
import com.icss.hr.emp.service.EmpService;
import com.icss.hr.emp.service.impl.EmpServiceImpl;
import com.icss.hr.emp.vo.Emp;
import com.icss.hr.job.vo.Job;

public class EmpUpdateServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private EmpService service= new EmpServiceImpl();
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try{
			String empid = request.getParameter("empid");
			String ename = request.getParameter("ename");
			String email = request.getParameter("email");
			String hiredate = request.getParameter("hiredate");
			String jobid = request.getParameter("jobid");
			String sal = request.getParameter("sal");
			String deptid = request.getParameter("deptid");
			int intDeptid = Integer.parseInt(deptid);
			int intempid = Integer.parseInt(empid);
			
			Emp emp = new Emp(intempid, ename, email, 
					Date.valueOf(hiredate),
					new Job(jobid,"", 0, 0), 
					new BigDecimal(sal), 
					new Dept(intDeptid, "",""));
			service.update(emp);
			
			request.getRequestDispatcher("/emp/empviewservlet").forward(request, response);
			
		}catch(Exception ex){
			ex.printStackTrace();
			request.setAttribute("errormsg", ex.getMessage());
			request.getRequestDispatcher("/error.jsp").forward(request, response);
		}
	}

}
