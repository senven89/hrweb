package com.icss.hr.dept.service.impl;

import java.util.List;

import com.icss.hr.dept.dao.DeptDao;
import com.icss.hr.dept.dao.impl.DeptDaoJdbcImpl;
import com.icss.hr.dept.service.DeptService;
import com.icss.hr.dept.vo.Dept;

public class DeptServiceImpl implements DeptService {
	private DeptDao dao = new DeptDaoJdbcImpl();

	public void delete(Dept dept) throws Exception {
		dao.delete(dept);
	}

	public void intsert(Dept dept) throws Exception {
		dao.intsert(dept);
	}

	public List<Dept> queryAll() throws Exception {
		return dao.queryAll();
	}

	public Dept queryById(int id) throws Exception {
		return dao.queryById(id);
	}

	public void update(Dept dept) throws Exception {
		dao.update(dept);
	}

}
