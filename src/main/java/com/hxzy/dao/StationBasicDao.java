package com.hxzy.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.hxzy.entity.StationBasic;


public interface StationBasicDao extends JpaRepository<StationBasic, Integer> {
	
	@Query("from com.hxzy.entity.StationBasic where station_kind = ?1")
	public StationBasic findOne(String station_kind);
}
