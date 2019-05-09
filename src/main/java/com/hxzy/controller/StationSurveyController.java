package com.hxzy.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.hxzy.entity.StationBasic;
import com.hxzy.entity.StationSurvey;
import com.hxzy.service.StationSurveyService;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

@RestController
public class StationSurveyController {
	/**
	 * 站点检测控制
	 * 出水口水质，出水口流量，电控箱开合状态
	 * */
	
	/**
	 * 注入stationsurveyservice
	 * */
	@Resource(name="stationSurveyService")
	private StationSurveyService stationSurveyService;
	
	/**
	 * 每隔一个小时要存入一次站点检测表
	 * */
	
	
	/**
	 * @admin
	 * 批量删除
	 * */
	
	
	/**
	 * 由站点编号和当前时间查出实时监测表
	 * */
	@GetMapping("/getonestationsurvey/{time}")
	public String findOneStationSurvey(@PathVariable(name="time",required=true) String time) {
		JSONObject stationSurveyJSON = null;
		StationSurvey stationSUrvey = stationSurveyService.findOneStationSurvey(MapController.station_id, Integer.parseInt(time));
		System.out.println("gz:"+MapController.station_id);
		try {
			stationSUrvey.setStationBasic(null);
			stationSurveyJSON = JSONObject.fromObject(stationSUrvey); 
		}catch(Exception e) {
			System.out.println("aaa1");
		}
		return stationSurveyJSON.toString();
	}
	
	/**
	 * 由站点编号查出该站点所有监测表
	 * */
	@GetMapping("/getonestationsurvey/list")
	public String getOneStationAllSurvey() {
		List<StationSurvey> surveyList = stationSurveyService.findAllStationSurvey(MapController.station_id);
		for(StationSurvey ss: surveyList) {
			ss.setStationBasic(null);
		}
		JSONArray surveyJSON = JSONArray.fromObject(surveyList);
		return surveyJSON.toString();
	}
	
}
