package com.hxzy.controller;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.annotation.Resource;
import javax.persistence.Transient;

import org.apache.catalina.core.StandardService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hxzy.entity.StationBasic;
import com.hxzy.entity.Warning;
import com.hxzy.service.StationBasicService;
import com.hxzy.service.WarningService;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;
import net.sf.json.util.CycleDetectionStrategy;

@RestController
public class WarningController {
	private WarningService warningService;
	private StationBasicService stationService;
	@Resource(name="stationBasicServiceImpl")
	public void setStationService(StationBasicService stationService) {
		this.stationService = stationService;
	}
	@Resource(name="warningServiceImpl")
	public void setWarningService(WarningService warningService) {
		this.warningService = warningService;
	}
	@GetMapping("/seleteWarning")
	public String getWarning() {
			JsonConfig jsonConfig = new JsonConfig();  
			jsonConfig.setCycleDetectionStrategy(CycleDetectionStrategy.LENIENT);  
			List<Warning> warnings = warningService.getWarningList();
			JSONArray obj = JSONArray.fromObject(warnings,jsonConfig); 
			System.out.println(obj.toString());
			return obj.toString();	
	}
	
	@PostMapping("/deleteWarning")
	public String deleteWarning(@ModelAttribute Warning warning) {
		try {
			System.out.println("***********"+warning.getWarning_id());
			warningService.deleteWarningList(warning);
		} catch (Exception e) {
			// TODO: handle exceptione
			e.printStackTrace();
			return "N";
		}
		return "Y";
	}
	
	@PostMapping("/updateWarning")
	public String updateWarning(@ModelAttribute Warning warning) {
		try {
			warning.setWarning_wetherValid("无效告警");
			warningService.updateinfo(warning);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return "N";
		}
		return "Y";
	}
}
