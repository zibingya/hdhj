package com.hxzy.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import com.hxzy.entity.StationBasic;

public interface StationBasicDao extends JpaRepository<StationBasic, Integer>, JpaSpecificationExecutor<StationBasic> {

	@Query("from com.hxzy.entity.StationBasic s ORDER BY s.station_no desc")
	public Page<StationBasic> findInOrders(Pageable pageable);
	@Query("from com.hxzy.entity.StationBasic where station_kind = ?1")
	public StationBasic findOne(String station_kind);
}
