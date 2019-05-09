package com.hxzy.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.hxzy.entity.PatrolInspectionSheet;

/**
 * PatrolInspectionSheetDao实现巡检工单的增删改查
 * */
public interface PatrolInspectionSheetDao extends JpaRepository<PatrolInspectionSheet,Integer>{
	
	@Query("from com.hxzy.entity.PatrolInspectionSheet pis where pis_station_no = :station_no and pis_time = :time")
	public PatrolInspectionSheet findOnePIS(int station_no,String time);
}
