package com.hxzy.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.hxzy.entity.PatrolInspectionSheet;
import com.hxzy.entity.StationBasic;
import com.hxzy.service.PatrolInspectionSheetService;

import net.sf.json.JSONObject;

/**
 * 巡检工单控制器
 * */
@RestController
public class PatrolInspectionSheetController {
	
	/**注入PatrolInspectionSheetService*/
	@Resource(name="patrolInspectionSheetServiceImpl")
	private PatrolInspectionSheetService patrolInspectionSheetService;
	
	@GetMapping("/findonepis/{day}")
	public String findOnePatrolInspectionSheet(@PathVariable(name="day")String day) {
		PatrolInspectionSheet patrolInspectionSheet = patrolInspectionSheetService.findOnePatrolInspectionSheet(MapController.station_id,day);
		patrolInspectionSheet.setStationBasic(null);
		JSONObject patrolInspectionSheetJSON = JSONObject.fromObject(patrolInspectionSheet);
		return patrolInspectionSheetJSON.toString();	
	}
}
