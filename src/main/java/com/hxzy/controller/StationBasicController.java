package com.hxzy.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.hxzy.entity.PowerMachine;
import com.hxzy.entity.StationBasic;
import com.hxzy.entity.StationSurvey;
import com.hxzy.service.PowerMachineService;
import com.hxzy.service.StationBasicService;
import com.hxzy.service.StationSurveyService;

@RestController
public class StationBasicController {
	/**
	 * 1.地图呈现控制器
	 * 展示地图：站点名称，站点类型(以颜色表示各种站点)
	 * 点击一个站点(findonestation)-->站点基础信息
	 * 2.站点基础信息控制器
	 * 增删改查handler(add,del,upd,findall)-->视图ModelAndView展示站点信息
	 * 包含基础信息，站点检测，动力设备，巡检工单，站点qqs，考勤记录
	 * */
	
	/**
	 * 注入StationBasicService，包含增删改查功能
	 * */
	@Resource(name="stationBasicService")
	private StationBasicService stationBasicService;
	
	/**
	 * add
	 * 添加单个站点
	 * */
	@GetMapping("/addstationbasic/stationbasic")
	public ModelAndView addStationBasic(ModelAndView mav,@ModelAttribute StationBasic stationBasic) {
		mav.setViewName("redirect:/stationbasic");//重定向到站点基础信息页面
		stationBasicService.addStationBasic(stationBasic);;//添加
		return mav;
	}
	
	/**
	 * del
	 * 删除单个站点
	 * */
	@GetMapping("/delstationbasic/{id}")
	public ModelAndView delStationBasic(ModelAndView mav,@ModelAttribute StationBasic stationBasic) {
		mav.setViewName("redirect:/stationbasic");//重定向到站点基础信息页面
		stationBasicService.delStationBasic(stationBasic.getStation_no());//删除
		return mav;
	}
	
	/**
	 * update
	 * 编辑单个站点
	 * */
	@GetMapping("/updstationbasic/stationbasic")
	public ModelAndView updateStationBasic(ModelAndView mav,@ModelAttribute StationBasic stationBasic) {
		mav.setViewName("redirect:/stationbasic");//重定向到站点基础信息页面
		stationBasicService.addStationBasic(stationBasic);;//更新
		return mav;
	}
	
	/**
	 * find one station
	 * 查询单个站点
	 * */
	@GetMapping("/findonestationbasic/{con}")
	@ResponseBody()
	public ModelAndView showChooesedStation(ModelAndView mav,@PathVariable(name="con")int con,HttpSession session) {
		mav.setViewName("/showstationbase");//重定向到站点基础信息展示页面
		System.out.println("gz");
//		mav.addObject("stationSurvey",findOneStationSurvey(stationBasicService.findStationBasic(con), 1) );
		mav.addObject("stationBasic",stationBasicService.findStationBasic(con));//从数据库中查
//		int time = Integer.parseInt((String) session.getAttribute("time"));
//		int time = 1;
//		mav.addObject("powerMachine", findOnePowerMachine(time));
		return mav;
	}
	
	/**
	 * find all stations
	 * 查看全站点
	 * */
	@GetMapping("/stationbasic")
	public ModelAndView findAllBasic(ModelAndView mav,@ModelAttribute StationBasic stationBasic,HttpSession session) {
		List<StationBasic> stationBasicList = stationBasicService.findStationBasic();//查询list
		session.setAttribute("stationBasicList", stationBasicList);
		mav.addObject("stationBasicList", stationBasicList);
		mav.setViewName("/stationbasics");//转到站点基础信息页面
		return mav;
	}
	
	/**
	 *stationbasics-->stationbasic查询后-->stationbasics.ftl
	 * */
	@GetMapping("/seestationbasics")
	public ModelAndView index(ModelAndView mav) {
		mav.setViewName("forward:/stationbasic");
		return mav;
	}

}