package com.icss.hr.emp.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.icss.hr.emp.service.EmpService;
import com.icss.hr.emp.service.impl.EmpServiceImpl;
import com.icss.hr.emp.vo.Emp;

public class EmpDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private EmpService service= new EmpServiceImpl();
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			String EmpId = request.getParameter("EmpId");
			int intEmpId = Integer.parseInt(EmpId);
			Emp emp = service.queryById(intEmpId);
			service.delete(emp);
			request.getRequestDispatcher("/emp/empviewservlet").forward(request, response);
		}catch(Exception ex){
			ex.printStackTrace();
			request.setAttribute("errormsg", ex.getMessage());
			request.getRequestDispatcher("/error.jsp").forward(request, response);
		}
	}

}
