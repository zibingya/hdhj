package com.hxzy.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.hxzy.entity.AttendanceRecord;

public interface AttendanceRecordDao extends JpaRepository<AttendanceRecord, Integer>{
	
	@Query("from AttendanceRecord ar where ar.stationBasic.station_no = :station_no")
	public AttendanceRecord finOneAttendanceRecord(int station_no);
}
