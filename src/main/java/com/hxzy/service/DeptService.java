package com.hxzy.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.hxzy.entity.Dept;

public interface DeptService {
	
	public List<Dept> getDeptList();
	
	public void delDept(Dept dept);
	
	public Dept addDept(Dept dept);
	
	public void updateDept(Dept dept);
	
	public Page<Dept> fy(int page, int size);
}
