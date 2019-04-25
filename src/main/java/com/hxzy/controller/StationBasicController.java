package com.hxzy.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hxzy.entity.StationBasic;
import com.hxzy.service.StationBasicService;

import net.sf.json.JSONObject;



@RestController
public class StationBasicController {
	private StationBasicService stationBasicService;

	@Resource(name="stationBasicServiceImpl")
	public void setStationBasicService(StationBasicService stationBasicService) {
		this.stationBasicService = stationBasicService;
	}
	
	@GetMapping("/")//@RequestBody HttpServletResponse response
	public void getStationBasics() {
		List<StationBasic> stationBasics = stationBasicService.getStationBasicList();
		/*
		JSONObject obj =JSONObject.fromObject(info);
		PrintWriter pw = response.getWriter();
	    System.out.println(obj.toString());
		pw.write(obj.toString());
		 */
		JSONObject obj = JSONObject.fromObject(stationBasics); 
		System.out.println(obj.toString());
		PrintWriter pw = null;
//		try {
//			pw = response.getWriter();
//			
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}finally {
//			if(pw != null) {
//				pw.close();
//			}
//		}
		
	}
}
