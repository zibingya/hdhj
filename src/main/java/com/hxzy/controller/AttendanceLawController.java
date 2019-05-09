package com.hxzy.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hxzy.entity.AttendanceLaw;
import com.hxzy.entity.StationBasic;
import com.hxzy.entity.Warning;
import com.hxzy.service.AttendanceLawService;
import com.hxzy.service.StationBasicService;

import net.sf.json.JSONArray;
import net.sf.json.JsonConfig;
import net.sf.json.util.CycleDetectionStrategy;

@RestController
public class AttendanceLawController {
	
	private AttendanceLawService attendanceLawService;
	
	@Resource(name="stationBasicServiceImpl")
	private StationBasicService stationBasicService;
	
	@Resource(name="AttendanceLawServiceImpl")
	public void setAttendanceLawService(AttendanceLawService attendanceLawService) {
		this.attendanceLawService = attendanceLawService;
	}
	
	@GetMapping("/selectAttendanceLaw")
	public String getAttendanceLaw() {
		JsonConfig jsonConfig = new JsonConfig();  
		jsonConfig.setCycleDetectionStrategy(CycleDetectionStrategy.LENIENT);  
		List<AttendanceLaw> attendanceLaws = attendanceLawService.getAttendanceLawList();
		JSONArray obj = JSONArray.fromObject(attendanceLaws,jsonConfig); 
		System.out.println(obj.toString());
		return obj.toString();	
	}
	
	@PostMapping("/addAttendanceLaw")
	public String addAttendanceLaw(@ModelAttribute AttendanceLaw attendanceLaw,@RequestParam String station_kind) {
		StationBasic sb = stationBasicService.findOne(station_kind);
		sb.setStation_kind(station_kind);
		attendanceLaw.setStationBasic(sb);
		try {
			attendanceLawService.addAttendanceLaw(attendanceLaw);			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return "N";
		}
		return "Y";
	}
	
	@PostMapping("/deleteattendanceLaw")
	public String deleteAttendanceLaw(@ModelAttribute AttendanceLaw attendanceLaw) {
		try {
			System.out.println("*****************"+attendanceLaw.getAttendanceLaw_id());
			attendanceLawService.deleteAttendanceLaw(attendanceLaw);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return "N";
		}
		return "Y";
	}
	
	@PostMapping("/updateAttendanceLaw")
	public String updateAttendanceLaw(@ModelAttribute AttendanceLaw attendanceLaw,@RequestParam String station_kind) {
		StationBasic sb = stationBasicService.findOne(station_kind);
		sb.setStation_kind(station_kind);
		attendanceLaw.setStationBasic(sb);
		try {
			attendanceLawService.updateAttendanceLaw(attendanceLaw);
		} catch (Exception e) {			
			// TODO: handle exception
			e.printStackTrace();
			return "N";
		}
		return "Y";
	}
}
