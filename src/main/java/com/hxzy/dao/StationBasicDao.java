package com.hxzy.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.hxzy.entity.StationBasic;

public interface StationBasicDao extends JpaRepository<StationBasic, Integer> {
	/**
	 * 站点基础信息do接口 继承父类实现站点信息的增删改查
	 */
	@Query("from com.hxzy.entity.StationBasic s where s.station_no = :id")
	public StationBasic finOne(int id);
}
