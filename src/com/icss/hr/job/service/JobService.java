package com.icss.hr.job.service;

import java.util.List;

import com.icss.hr.job.vo.Job;

public interface JobService {
	public void insert(Job job)throws Exception;
	public void update(Job job)throws Exception;
	public void delete(Job job)throws Exception;
	public Job queryById(String id)throws Exception;
	public List<Job> queryAll() throws Exception;

}
