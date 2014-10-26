package com.icss.hr.emp.vo;

import java.math.BigDecimal;
import java.sql.Date;

import com.icss.hr.dept.vo.Dept;
import com.icss.hr.job.vo.Job;

//Emp vo类:负责存储和传输数据
public class Emp {
	private int empId;
	private String ename;
	private String email;
	private Date hiredate;
	private Job job; // 多对一的标准
	private BigDecimal sal; // 比double的精度高
	private Dept dept;

	// 构造器
	

	public Emp(int empId, String ename, String email, Date hiredate, Job job,
			BigDecimal sal, Dept dept) {
		super();
		this.empId = empId;
		this.ename = ename;
		this.email = email;
		this.hiredate = hiredate;
		this.job = job;
		this.sal = sal;
		this.dept = dept;
	}

	public Emp() {
		super();
	}

	// 访问器
	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public String getEname() {
		return ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getHiredate() {
		return hiredate;
	}

	public void setHiredate(Date hiredate) {
		this.hiredate = hiredate;
	}

	public BigDecimal getSal() {
		return sal;
	}

	public void setSal(BigDecimal sal) {
		this.sal = sal;
	}

	public Job getJob() {
		return job;
	}

	public void setJob(Job job) {
		this.job = job;
	}

	public Dept getDept() {
		return dept;
	}

	public void setDept(Dept dept) {
		this.dept = dept;
	}

	@Override
	public boolean equals(Object obj) { // Emp要重写equal方法
		if (obj instanceof Emp) {
			Emp e = (Emp) obj;
			if (this.empId == e.getEmpId()) {
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}

	@Override
	public String toString() { // 封装 source-toString
		return empId + " " + ename + " " + email + " " + this.job.toString()
				+ " " + hiredate + " " + sal + this.dept.toString();
	}
}
