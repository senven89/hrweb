package com.icss.hr.dept.service;

import java.util.List;

import com.icss.hr.dept.vo.Dept;

public interface DeptService {
	public void intsert(Dept dept)throws Exception;  //增加
	public void update(Dept dept)throws Exception;   //修改
	public void delete(Dept dept)throws Exception;   //删除
	public Dept queryById(int id)throws Exception;  //查询单个
	public List<Dept> queryAll()throws Exception;   //查询所有

}
