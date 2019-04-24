package com.hxzy.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hxzy.entity.StationBasic;


public interface StationBasicDao extends JpaRepository<StationBasic, Integer> {
	
}
