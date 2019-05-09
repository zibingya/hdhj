package com.hxzy.controller;

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
import com.hxzy.service.PowerMachineService;

import net.sf.json.JSONObject;
@RestController
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
	
	/**
	 * 设备管理员单个删除
	 * */
	
	/**
	 * powermachine单个修改
	 * */
	
	/**
	 * 由time和station_no单个查询powermachine
	 * */
	@GetMapping("/findonepowermachine/{hour}")
	public String findOnePowerMachine(@PathVariable(name="hour") String hour) {
		System.out.println("123");
		PowerMachine powerMachine = powerMachineService.findOnePowerMachine(MapController.station_id,Integer.parseInt(hour));
		powerMachine.setStationBasic(null);
		JSONObject powerMachineJSON = JSONObject.fromObject(powerMachine);
	    return powerMachineJSON.toString();
	}
}
