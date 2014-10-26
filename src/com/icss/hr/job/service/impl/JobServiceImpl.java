package com.icss.hr.job.service.impl;

import java.util.List;

import com.icss.hr.job.dao.JobDao;
import com.icss.hr.job.dao.impl.JobDaoJdbcImpl;
import com.icss.hr.job.service.JobService;
import com.icss.hr.job.vo.Job;

public class JobServiceImpl implements JobService {
	private JobDao dao = new JobDaoJdbcImpl();
	public void delete(Job job) throws Exception {
		dao.delete(job);
	}

	public void insert(Job job) throws Exception {
		dao.insert(job);
	}

	public List<Job> queryAll() throws Exception {
		return dao.queryAll();
	}

	public Job queryById(String id) throws Exception {
		return dao.queryById(id);
	}

	public void update(Job job) throws Exception {
		dao.update(job);
	}

}
