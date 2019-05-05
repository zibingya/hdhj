package com.hxzy.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.hxzy.entity.SystemLog;



public interface SystemLogDao extends JpaRepository<SystemLog, Integer> {

	@Query("from com.hxzy.entity.SystemLog s ORDER BY s.id desc")
	Page<SystemLog> findInOrders(Pageable pageable);
}
