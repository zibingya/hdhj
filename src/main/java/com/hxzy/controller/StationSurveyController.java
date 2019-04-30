package com.hxzy.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.hxzy.entity.StationBasic;
import com.hxzy.entity.StationSurvey;
import com.hxzy.service.StationSurveyService;

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
	@GetMapping("/addstationsurvey")
	public ModelAndView addStationSurvey(@ModelAttribute StationSurvey stationSurvey,ModelAndView mav) {
		mav.setViewName("redirect:/stationsurvey");
		stationSurveyService.addStationSurvey(stationSurvey);//存入最新监测信息
		return mav;
	}
	
	/**
	 * @admin
	 * 批量删除
	 * */
	@GetMapping("/delstationsurvey")
	public ModelAndView delStationSurvey(@ModelAttribute List<Integer> times,ModelAndView mav) {
		mav.setViewName("redirect:/stationsurvey");
		stationSurveyService.delStationSurvey(times);//dba批量删除监测信息
		return mav;
	}
	
	/**
	 * 由站点编号和当前时间查出实时监测表
	 * */
	@GetMapping("/findonestationsurvey/{time}")
	public ModelAndView findOneStationSurvey(@ModelAttribute StationBasic stationBasic,@PathVariable(name="time",required=true) int time,ModelAndView mav) {
		mav.addObject("stationSurvey", stationSurveyService.findOneStationSurvey(stationBasic.getStation_no(),time));//查出该站点该时刻的监测信息
		mav.setViewName("/stationsurvey");
		return mav;
	}
	
	/**
	 * 由站点编号查出该站点所有监测表
	 * */
	public ModelAndView findOneStationAllSurvey(@ModelAttribute int station_no,ModelAndView mav) {
		mav.addObject("stationSurvey", stationSurveyService.findAllStationSurvey(station_no));//查出该站点历史监测信息而后在页面组合成不同报表
		mav.setViewName("rediret:stationsurvey");
		return mav;
	}
	
}
