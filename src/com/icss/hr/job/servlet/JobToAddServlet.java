package com.icss.hr.job.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.icss.hr.job.service.JobService;
import com.icss.hr.job.service.impl.JobServiceImpl;
import com.icss.hr.job.vo.Job;

public class JobToAddServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private JobService service = new JobServiceImpl();
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			String jobid = request.getParameter("jobid");
			String jobname = request.getParameter("jobname");
			String minsalary = request.getParameter("minsalary");
			String maxsalary = request.getParameter("maxsalary");
			int intminsalary = Integer.parseInt(minsalary);
			int intmaxsalary = Integer.parseInt(maxsalary);
			
			Job job = new Job(jobid, jobname, intminsalary, intmaxsalary);
			service.insert(job);
			request.getRequestDispatcher("/job/jobviewservlet").forward(request, response);
		}catch(Exception ex){
			ex.printStackTrace();
			request.setAttribute("errormsg", ex.getMessage());
			request.getRequestDispatcher("/error.jsp").forward(request, response);
		}
	}

}
