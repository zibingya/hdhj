package com.hxzy.service.impl;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import org.springframework.stereotype.Component;

import com.hxzy.dao.AttendanceRecordDao;
import com.hxzy.entity.AttendanceRecord;
import com.hxzy.service.AttendanceRecordService;

@Component(value="attendanceRecordServiceImpl")
public class AttendanceRecordServiceImpl implements AttendanceRecordService{

	/**
	 * 注入attencanceRecordDao
	 * */
	@Resource
	private AttendanceRecordDao attendanceRecordDao;
	
	/**
	 * 由站点编号查出该站点所有考勤记录并分页展示
	 * */
	@Transactional
	@Override
	public AttendanceRecord finOneAttendanceRecord(int station_no) {
		// TODO Auto-generated method stub
		return attendanceRecordDao.finOneAttendanceRecord(station_no);
	}

}
