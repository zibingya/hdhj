package com.hxzy.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import com.hxzy.dao.EmployeeDao;
import com.hxzy.entity.Dept;
import com.hxzy.entity.Employee;
import com.hxzy.service.EmployeeService;

//镇压
@SuppressWarnings("finally")
@Component("employeeServiceImpl")
public class EmployeeServiceImpl implements EmployeeService {

	private EmployeeDao employeeDao;

	@Resource
	public void setEmployeeDao(EmployeeDao employeeDao) {
		this.employeeDao = employeeDao;
	}

	@Override
	public List<Employee> getEmployeeList() {
		// TODO Auto-generated method stub
		return employeeDao.findAll();
	}

	@Override
	public Employee addEmployee(Employee Employee) {
		// TODO Auto-generated method stub
		Employee temp = null;
		try {
			temp = employeeDao.save(Employee);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			return temp;
		}
	}

	@Override
	public void delEmployee(Employee Employee) {
		// TODO Auto-generated method stub
		employeeDao.delete(Employee);
	}

	@Override
	public Employee updateEmployee(Employee Employee) {
		// TODO Auto-generated method stub
		Employee temp = null;
		try {
			temp = employeeDao.save(Employee);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			return temp;
		}
	}

	@Override
	@SuppressWarnings("deprecation")
	public Page<Employee> fy(int page, int size) {
		// TODO Auto-generated method stub
		Pageable pageable = new PageRequest(page, size);
		Page<Employee> employees = employeeDao.findAll(pageable);
		return employees;
	}
}
