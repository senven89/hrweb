package com.icss.hr.emp.service;

import java.util.List;

import com.icss.hr.emp.vo.Emp;

public interface EmpService {
//�ýӿڹ涨�ù���
		public void intsert(Emp emp)throws Exception;  //����
		public void update(Emp emp)throws Exception;   //�޸�
		public void delete(Emp emp)throws Exception;   //ɾ��
		public Emp queryById(int id)throws Exception;  //��ѯ����
		public List<Emp> queryAll()throws Exception;   //��ѯ����
	}
