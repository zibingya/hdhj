package com.hxzy.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import com.hxzy.entity.Dept;

public interface DeptDao extends JpaRepository<Dept, Integer>,JpaSpecificationExecutor<Dept> {

	@Query("from com.hxzy.entity.Dept d ORDER BY d.deptno desc")
	Page<Dept> findInOrders(Pageable pageable);
}
