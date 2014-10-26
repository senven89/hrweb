package com.icss.hr.test;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.List;

import com.icss.hr.dept.vo.Dept;
import com.icss.hr.emp.dao.impl.EmpDaoJdbcImpl;
import com.icss.hr.emp.vo.Emp;
import com.icss.hr.job.vo.Job;

//测试类test
public class EmpDaoTest {
	public static void insert(){
		EmpDaoJdbcImpl dao = new EmpDaoJdbcImpl();
		Emp emp = new Emp(100, "张三", "zs@163.com", Date.valueOf("2014-03-26"),
				new Job("AD_VP","", 0, 0), new BigDecimal(2000), new Dept(10, "",
						""));
		try {
			dao.intsert(emp);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void update(){
		EmpDaoJdbcImpl dao = new EmpDaoJdbcImpl();
		Emp emp = new Emp(14, "张三2", "zs2@163.com", Date.valueOf("2014-03-26"),
				new Job("AD_VP","", 0, 0), new BigDecimal(2000), new Dept(10, "",
						""));
		try {
			dao.update(emp);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static void delete(){
		EmpDaoJdbcImpl dao = new EmpDaoJdbcImpl();
		Emp emp = new Emp();
		emp.setEmpId(20);
		try {
			dao.delete(emp);
		} catch (Exception e) { 
			e.printStackTrace();
		}
	}
	
	public static void queryById(){
		EmpDaoJdbcImpl dao = new EmpDaoJdbcImpl();
		Emp newemp;
		try {
			newemp = dao.queryById(25);
			System.out.println(newemp);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	public static void queryAll(){
		EmpDaoJdbcImpl dao = new EmpDaoJdbcImpl();
		try {
			List<Emp> list = dao.queryAll();
			for(Emp e:list)
				System.out.println(e);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	public static void main(String[] args) {
		update();
	}
}
