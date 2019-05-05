package com.hxzy.controller;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hxzy.entity.SystemLog;
import com.hxzy.service.SystemLogService;

import net.sf.json.JSONObject;

/**
 * 系统日志COntroller
 * @author ZengLang
 * */
@RestController
public class SystemLogController {
	
	@Resource(name="systemLogServiceImpl")
	private SystemLogService systemLogService;
	
	@GetMapping("/get/systemlog")
	public String getPage(@RequestParam("page") int page, @RequestParam("limit") int limit) {
		Page<SystemLog> logs = systemLogService.fy(page-1, limit);
		JSONObject obj = JSONObject.fromObject(logs);
		return obj.toString();
	}
}
