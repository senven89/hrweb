package com.icss.hr.dept.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.icss.hr.dept.service.DeptService;
import com.icss.hr.dept.service.impl.DeptServiceImpl;
import com.icss.hr.dept.vo.Dept;

public class DeptUpdateServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private DeptService service = new DeptServiceImpl();
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			String deptid = request.getParameter("deptid");
			String deptname = request.getParameter("deptname");
			String deptloc = request.getParameter("deptloc");
			int intdeptid = Integer.parseInt(deptid);
			Dept dept = new Dept(intdeptid, deptname, deptloc);
			service.update(dept);
			request.getRequestDispatcher("/dept/deptviewservlet").forward(request, response);
		}catch(Exception ex){
			ex.printStackTrace();
			request.setAttribute("errormsg", ex.getMessage());
			request.getRequestDispatcher("/error.jsp").forward(request, response);
		}
	}

}
