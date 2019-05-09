package com.hxzy.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hxzy.entity.StationBasic;
import com.hxzy.service.StationBasicService;

import net.sf.json.JSONArray;
import net.sf.json.JsonConfig;
import net.sf.json.util.CycleDetectionStrategy;



@RestController
public class StationBasicController {
	private StationBasicService stationBasicService;

	@Resource(name="stationBasicServiceImpl")
	public void setStationBasicService(StationBasicService stationBasicService) {
		this.stationBasicService = stationBasicService;
	}
	
	@GetMapping("/stationbasic")
	public String getStationBasics() {
		JsonConfig jsonConfig = new JsonConfig();  
		jsonConfig.setCycleDetectionStrategy(CycleDetectionStrategy.LENIENT);  
		List<StationBasic> stationBasics = stationBasicService.getStationBasicList();
		JSONArray obj = JSONArray.fromObject(stationBasics,jsonConfig); 
		System.out.println(obj.toString());
		return obj.toString();	
	}
}
