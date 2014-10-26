package com.icss.hr.emp.service.impl;

import java.util.List;

import com.icss.hr.emp.dao.EmpDao;
import com.icss.hr.emp.dao.impl.EmpDaoJdbcImpl;
import com.icss.hr.emp.service.EmpService;
import com.icss.hr.emp.vo.Emp;

public class EmpServiceImpl implements EmpService {
	private EmpDao dao = new EmpDaoJdbcImpl();
	public void delete(Emp emp) throws Exception {
		dao.delete(emp);
	}

	public void intsert(Emp emp) throws Exception {
		dao.intsert(emp);
	}

	public List<Emp> queryAll() throws Exception {
		return dao.queryAll();
	}

	public Emp queryById(int id) throws Exception {
		return dao.queryById(id);
	}

	public void update(Emp emp) throws Exception {
		dao.update(emp);
	}

}
