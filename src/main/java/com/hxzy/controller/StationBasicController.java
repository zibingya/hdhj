package com.hxzy.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
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
	@GetMapping("/findonestationbasic/{id}")
	public ModelAndView showChooesedStation(ModelAndView mav,@PathVariable(name="id",required=true) int id,HttpSession session) {
		mav.setViewName("/showstationbase");//重定向到站点基础信息展示页面
		mav.addObject("stationSurvey",findOneStationSurvey(stationBasicService.findStationBasic(id), 1) );
		mav.addObject("stationBasic",stationBasicService.findStationBasic(id));//从数据库中查
//		int time = Integer.parseInt((String) session.getAttribute("time"));
		int time = 1;
		mav.addObject("powerMachine", findOnePowerMachine(time));
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
		mav.setViewName("redirect:/showstationbase");
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
	public StationSurvey findOneStationSurvey(StationBasic stationBasic,int time) {
		StationSurvey stationSurvey =  stationSurveyService.findOneStationSurvey(stationBasic.getStation_no(),time);//查出该站点该时刻的监测信息
		return stationSurvey;
	}
	
	/**
	 * 由站点编号查出该站点所有监测表
	 * */
	public List<StationSurvey> findOneStationAllSurvey(int station_no) {
		List<StationSurvey> list = stationSurveyService.findAllStationSurvey(station_no);//查出该站点历史监测信息而后在页面组合成不同报表
		return list;
	}
	
	/**
	 * 动力设备
	 * */
	
	/**
	 * 注入powermachineservice
	 * */
	@Resource(name="powerMachineServiceImpl")
	private PowerMachineService powerMachineService;
	
	/**
	 * 添加powermachine
	 * */
	@GetMapping("/addpowermachine")
	public ModelAndView addPowerMachine(@ModelAttribute PowerMachine powerMachine,ModelAndView mav) {
		powerMachineService.addPowerMachine(powerMachine);
		mav.setViewName("redirect:/showstationbase");
		return mav;
	}
	
	/**
	 * 设备管理员单个删除
	 * */
	@DeleteMapping("/delpowermachine/{id}")
	public ModelAndView delPowerMachineById(@ModelAttribute int time,ModelAndView mav) {
		powerMachineService.delPowerMachine(time);
		mav.setViewName("redirect:/showstationbase");
		return mav;
	}
	
	/**
	 * powermachine单个修改
	 * */
	@GetMapping("/updpowermachine/updpowermachine")
	public ModelAndView updPowerMachine(@ModelAttribute PowerMachine powerMachine,ModelAndView mav) {
		powerMachineService.addPowerMachine(powerMachine);
		mav.setViewName("redirect:/showstationbase");
		return mav;
	}
	
	/**
	 * 单个查询powermachine
	 * */
//	@GetMapping("/findpowermachine/{time}")
	public PowerMachine findOnePowerMachine(@PathVariable(name="time") int time) {
	    PowerMachine powerMachine = powerMachineService.findOne(time);
	    return powerMachine;
	}
}