package com.hxzy.service;

import java.util.List;

import com.hxzy.entity.AttendanceLaw;
import com.hxzy.entity.Warning;

public interface AttendanceLawService {
	public List<AttendanceLaw> getAttendanceLawList();//查询考勤规则列表
	
	public AttendanceLaw addAttendanceLaw(AttendanceLaw attendanceLaw);//添加考勤规则

	public void updateAttendanceLaw(AttendanceLaw attendanceLaw);//修改考勤规则
	
	public void deleteAttendanceLaw(AttendanceLaw attendanceLaw);//删除考勤规则
}
