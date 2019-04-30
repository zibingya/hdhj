package com.hxzy.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.hxzy.entity.StationBasic;
import com.hxzy.service.PatrolInspectionSheetService;

/**
 * 巡检工单控制器
 * */
@RestController
public class PatrolInspectionSheetController {
	
	/**注入PatrolInspectionSheetService*/
	@Resource(name="patrolInspectionSheetServiceImpl")
	private PatrolInspectionSheetService patrolInspectionSheetService;
	
	@GetMapping("/findonepis/{time}")
	public ModelAndView findOnePatrolInspectionSheet(@PathVariable(name="time")int time,ModelAndView mav,HttpSession session) {
		StationBasic stationBasic = (StationBasic) session.getAttribute("StationBasic");
		mav.addObject("patrolInspectionSheet",patrolInspectionSheetService.findOnePatrolInspectionSheet(stationBasic.getStation_no(), time));
		mav.setViewName("/showonepis");
		return mav;	
	}
}
