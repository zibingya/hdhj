package com.hxzy.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.hxzy.entity.StationBasic;
import com.hxzy.service.StationBasicService;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

@RestController
public class MapController {
	public static int station_id;
	/**
	 * 1.地图呈现控制器 展示地图：站点名称，站点类型(以颜色表示各种站点) 点击一个站点(findonestation)-->站点基础信息
	 * 2.站点基础信息控制器 增删改查handler(add,del,upd,findall)-->视图ModelAndView展示站点信息
	 * 包含基础信息，站点检测，动力设备，巡检工单，站点qqs，考勤记录
	 */

	/**
	 * 注入StationBasicService，包含增删改查功能
	 */
	@Resource(name = "stationBasicService")
	private StationBasicService stationBasicService;

	/**
	 * find one station 查询单个站点
	 */
	@GetMapping("/getonestationbasic/{con}")
	public String findOneStation(@PathVariable(name = "con") int con) {
		System.out.println("gz");
		station_id = con;
		StationBasic stationBasic = stationBasicService.findStationBasic(con);
		stationBasic.setPisSet(null);
		stationBasic.setPmSet(null);
		stationBasic.setSurveySet(null);
		JSONObject stationBasicObj = JSONObject.fromObject(stationBasic);
		return stationBasicObj.toString();
	}

	/**
	 * find all stations 查看全站点
	 */
	@GetMapping("/getstationbasic/list")
	public String findAllBasic(ModelAndView mav, HttpSession session) {
		List<StationBasic> stationBasicList = stationBasicService.getStationBasicList();// 查询list
		for(StationBasic stationBasic:stationBasicList) {
			stationBasic.setPisSet(null);
			stationBasic.setPmSet(null);
			stationBasic.setSurveySet(null);
		}
		JSONArray stationArray = JSONArray.fromObject(stationBasicList);
		return stationArray.toString();
	}

}
