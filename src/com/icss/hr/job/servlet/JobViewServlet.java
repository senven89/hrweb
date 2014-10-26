package com.icss.hr.job.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.icss.hr.job.service.JobService;
import com.icss.hr.job.service.impl.JobServiceImpl;
import com.icss.hr.job.vo.Job;

public class JobViewServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private JobService service = new JobServiceImpl();
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try{
			List<Job> list = service.queryAll();
			request.setAttribute("list", list);
			
			request.getRequestDispatcher("/job/jobview.jsp").forward(request, response);
		}catch(Exception ex){
			ex.printStackTrace();
			request.setAttribute("errormsg", ex.getMessage());
			request.getRequestDispatcher("/error.jsp").forward(request, response);
		}
	}

}
