package com.icss.hr.emp.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.icss.hr.job.service.JobService;
import com.icss.hr.job.service.impl.JobServiceImpl;
import com.icss.hr.job.vo.Job;

public class JobDelServlet extends HttpServlet {
	private JobService service = new JobServiceImpl();
	private static final long serialVersionUID = 1L;
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			String jobid = request.getParameter("jobid");
			Job job = new Job();
			job.setJobId(jobid);
			service.delete(job);
			request.getRequestDispatcher("/job/jobviewservlet").forward(request, response);
		}catch(Exception ex){
			ex.printStackTrace();
			request.setAttribute("errormsg", ex.getMessage());
			request.getRequestDispatcher("/error.jsp").forward(request, response);
		}
	}

}
