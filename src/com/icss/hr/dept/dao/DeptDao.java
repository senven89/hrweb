package com.icss.hr.dept.dao;

import java.util.List;

import com.icss.hr.dept.vo.Dept;

public interface DeptDao {
	public void intsert(Dept dept)throws Exception;  //����
	public void update(Dept dept)throws Exception;   //�޸�
	public void delete(Dept dept)throws Exception;   //ɾ��
	public Dept queryById(int id)throws Exception;  //��ѯ����
	public List<Dept> queryAll()throws Exception;   //��ѯ����

}
