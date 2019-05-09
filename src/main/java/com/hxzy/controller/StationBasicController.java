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
	 * 2.站点基础信息控制器
	 * 增删改查handler(add,del,upd,findall)-->视图ModelAndView展示站点信息
	 * 包含基础信息，站点检测，动力设备，巡检工单，站点qqs，考勤记录
	 * */
	
	/**
	 * 注入StationBasicService，包含增删改查功能
	 * */
	@Resource(name="stationBasicService")
	private StationBasicService stationBasicService;
	
}
