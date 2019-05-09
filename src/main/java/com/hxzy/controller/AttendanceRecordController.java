package com.hxzy.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.hxzy.entity.AttendanceRecord;
import com.hxzy.entity.StationBasic;
import com.hxzy.service.AttendanceRecordService;

import net.sf.json.JSONObject;

/**考勤记录*/
@RestController
public class AttendanceRecordController {
	
	/**
	 * 注入attendanceRecordService
	 * */
	@Resource(name="attendanceRecordServiceImpl")
	private AttendanceRecordService attendanceRecordService;
	
	/**
	 * 由station_no查询该站点最近的考勤记录
	 * */
	@GetMapping("/findonear/{station_no}")
	public String findOneAttendanceRecord(@PathVariable(name="station_no")int station_no) {
		AttendanceRecord attendanceRecord = attendanceRecordService.finOneAttendanceRecord(station_no);
		attendanceRecord.setStationBasic(null);
		attendanceRecord.setAr_ename(attendanceRecord.getEmployee().getEname());
		attendanceRecord.setEmployee(null);
		JSONObject attendanceRecordJSON = JSONObject.fromObject(attendanceRecord);
		return attendanceRecordJSON.toString();
	}
}
