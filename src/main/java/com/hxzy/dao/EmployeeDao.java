package com.hxzy.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hxzy.entity.Employee;


public interface EmployeeDao extends JpaRepository<Employee, Integer> {

}
