package com.hxzy.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hxzy.entity.Warning;
import com.hxzy.service.WarningService;

import net.sf.json.JSONArray;

@RestController
public class WarningController {
	private WarningService warningService;
	@Resource(name="warningServiceImpl")
	public void setWarningService(WarningService warningService) {
		this.warningService = warningService;
	}
	@GetMapping("/warning")
	public String getWarning() {
		List<Warning> warnings = warningService.getWarningList();
		JSONArray obj = JSONArray.fromObject(warnings);
		System.out.println(obj.toString());
		System.out.println("lail");
		System.out.println();
		return obj.toString();
	}
}
