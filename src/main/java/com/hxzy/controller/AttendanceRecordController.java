package com.hxzy.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.hxzy.entity.StationBasic;
import com.hxzy.service.AttendanceRecordService;

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
	public ModelAndView findOneAttendanceRecord(@PathVariable(name="station_no")int station_no,ModelAndView mav,HttpSession session) {
		StationBasic stationBasic =  (StationBasic) session.getAttribute("StationBasic");
		mav.addObject("attendanceRecord", attendanceRecordService.finOneAttendanceRecord(stationBasic.getStation_no()));
		mav.setViewName("/showonear");
		return mav;
	}
}
