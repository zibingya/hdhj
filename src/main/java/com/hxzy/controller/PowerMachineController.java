package com.hxzy.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

import com.hxzy.entity.PowerMachine;
import com.hxzy.entity.StationBasic;
import com.hxzy.service.PowerMachineService;

public class PowerMachineController {
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
	 * 由time和station_no单个查询powermachine
	 * */
	@GetMapping("/findpowermachine/{id}")
	public ModelAndView findOnePowerMachine(@PathVariable(name="id") int pm_id,ModelAndView mav,HttpSession session) {
	    StationBasic stationBasic = (StationBasic) session.getAttribute("StationBasic");
	    int station_no = stationBasic.getStation_no();
		PowerMachine powerMachine = powerMachineService.findOnePowerMachine(station_no, pm_id);
		mav.addObject("powerMachine", powerMachine);
		mav.setViewName("/showpowermachine");
	    return mav;
	}
}
