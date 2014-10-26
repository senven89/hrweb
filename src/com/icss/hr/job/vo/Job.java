package com.icss.hr.job.vo;

public class Job {
	private String jobId;
	private String jobTitle;
	private int minSal;
	private int maxSal;
	
	//访问器
	public Job() {
		super();
	}
	public Job(String jobId, String jobTitle, int minSal, int maxSal) {
		super();
		this.jobId = jobId;
		this.jobTitle = jobTitle;
		this.minSal = minSal;
		this.maxSal = maxSal;
	}

	//构造器
	public String getJobId() {
		return jobId;
	}
	public void setJobId(String jobId) {
		this.jobId = jobId;
	}
	public String getJobTitle() {
		return jobTitle;
	}
	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}
	public int getMinSal() {
		return minSal;
	}
	public void setMinSal(int minSal) {
		this.minSal = minSal;
	}
	public int getMaxSal() {
		return maxSal;
	}
	public void setMaxSal(int maxSal) {
		this.maxSal = maxSal;
	}
	
	
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Job){
			Job j = (Job)obj;
			if(this.jobId == j.getJobId()){
				return true;
			}else{
				return false;
			}
		}else{
			return false;
		}
	}
	//重写toString
	@Override
	public String toString() {
		return jobId+" "+jobTitle+" "+minSal+" "+maxSal;
	}
	
	
}
