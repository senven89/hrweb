package com.icss.hr.emp.service;

import java.util.List;

import com.icss.hr.emp.vo.Emp;

public interface EmpService {
//用接口规定好规则
		public void intsert(Emp emp)throws Exception;  //增加
		public void update(Emp emp)throws Exception;   //修改
		public void delete(Emp emp)throws Exception;   //删除
		public Emp queryById(int id)throws Exception;  //查询单个
		public List<Emp> queryAll()throws Exception;   //查询所有
	}
