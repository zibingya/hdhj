package com.hxzy.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

import com.hxzy.dao.DeptDao;
import com.hxzy.entity.Dept;
import com.hxzy.service.DeptService;

@Component("deptServiceImpl")
public class DeptServiceImpl implements DeptService {

	private DeptDao deptDao;
	
	@Resource
	public void setDeptDao(DeptDao deptDao) {
		this.deptDao = deptDao;
	}
	
	@Override
	public List<Dept> getDeptList() {
		// TODO Auto-generated method stub
		return deptDao.findAll();
	}

	@Override
	public void delDept(Dept dept) {
		// TODO Auto-generated method stub
		deptDao.delete(dept);
	}

	@Override
	public Dept addDept(Dept dept) {
		// TODO Auto-generated method stub
		return deptDao.save(dept);
	}

	@Override
	public void updateDept(Dept dept) {
		// TODO Auto-generated method stub
		deptDao.save(dept);
	}

	@Override
	@SuppressWarnings("deprecation")
	public Page<Dept> fy(int page, int size) {
		// TODO Auto-generated method stub
		Sort sort = new Sort(Sort.Direction.ASC,"deptno");
		Pageable pageable = new PageRequest(page, size,sort);
		Page<Dept> depts = deptDao.findInOrders(pageable);
		
		return depts;
	}

}
