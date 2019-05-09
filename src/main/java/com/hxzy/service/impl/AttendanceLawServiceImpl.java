package com.hxzy.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.hxzy.dao.AttendanceLawDao;
import com.hxzy.entity.AttendanceLaw;
import com.hxzy.service.AttendanceLawService;
@Component("AttendanceLawServiceImpl")
public class AttendanceLawServiceImpl implements AttendanceLawService{
	
	private AttendanceLawDao attendanceLawDao;
	@Resource
	public void setAttendanceLawDao(AttendanceLawDao attendanceLawDao) {
		this.attendanceLawDao = attendanceLawDao;
	}

	@Override
	public List<AttendanceLaw> getAttendanceLawList() {
		// TODO Auto-generated method stub
		return attendanceLawDao.findAll();
	}
	

	@Override
	public AttendanceLaw addAttendanceLaw(AttendanceLaw attendanceLaw) {
		// TODO Auto-generated method stub
		return attendanceLawDao.save(attendanceLaw);
	}

	@Override
	public void updateAttendanceLaw(AttendanceLaw attendanceLaw) {
		// TODO Auto-generated method stub
		attendanceLawDao.save(attendanceLaw);
	}

	@Override
	public void deleteAttendanceLaw(AttendanceLaw attendanceLaw) {
		// TODO Auto-generated method stub
		attendanceLawDao.delete(attendanceLaw);
	}

}
