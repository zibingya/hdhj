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



@RestController
public class StationBasicController {
	private StationBasicService stationBasicService;

	@Resource(name="stationBasicServiceImpl")
	public void setStationBasicService(StationBasicService stationBasicService) {
		this.stationBasicService = stationBasicService;
	}
	
	@GetMapping("/stationbasic")
	public String getStationBasics() {
		List<StationBasic> stationBasics = stationBasicService.getStationBasicList();
		if(stationBasics == null) {
			System.out.println("null"+stationBasics);
		}
		JSONArray obj = JSONArray.fromObject(stationBasics); 
		System.out.println(obj.toString());
		return obj.toString();	
	}
}
