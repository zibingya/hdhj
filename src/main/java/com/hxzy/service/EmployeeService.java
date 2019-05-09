package com.hxzy.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.hxzy.entity.Employee;

public interface EmployeeService {

	//查找所有
	public List<Employee> getEmployeeList();
	//新增
	public Employee addEmployee(Employee Employee);
	//删除
	public void delEmployee(Employee Employee);
	//更新
	public Employee updateEmployee(Employee Employee);
	//分页
	public Page<Employee> fy(int page, int size);
}
