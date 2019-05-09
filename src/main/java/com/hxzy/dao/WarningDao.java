package com.hxzy.dao;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.hxzy.entity.Warning;

public interface WarningDao extends JpaRepository<Warning, Integer>{
	
	@Transactional //开启事务 
	@Modifying(clearAutomatically = true)//刷新hibernate一级缓存
	@Query(value ="update warning set warning_wether_valid = '无效告警' where warning_id = ?1",nativeQuery = true)
	public void updateinfo(int id);
}
