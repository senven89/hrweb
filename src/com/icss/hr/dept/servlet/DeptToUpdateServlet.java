package com.icss.hr.dept.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.icss.hr.dept.service.DeptService;
import com.icss.hr.dept.service.impl.DeptServiceImpl;
import com.icss.hr.dept.vo.Dept;

public class DeptToUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private DeptService service = new DeptServiceImpl();
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		try {
			String deptId = request.getParameter("deptId");
			int intdeptId = Integer.parseInt(deptId);
			Dept dept = service.queryById(intdeptId);
			request.setAttribute("dept", dept);
			request.getRequestDispatcher("/dept/deptupdate.jsp").forward(request, response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
