package com.hxzy.service.impl;

import javax.annotation.Resource;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import com.hxzy.dao.SystemLogDao;
import com.hxzy.entity.StationBasic;
import com.hxzy.entity.SystemLog;
import com.hxzy.service.SystemLogService;

@Component("systemLogServiceImpl")
public class SystemLogServiceImpl implements SystemLogService {

	@Resource
	private SystemLogDao systemLogDao;
	
	
	@Override
	public SystemLog addSystemLog(SystemLog systemLog) {
		// TODO Auto-generated method stub
		return systemLogDao.save(systemLog);
	}


	@Override
	public Page<SystemLog> fy(int page, int size) {
		// TODO Auto-generated method stub
		@SuppressWarnings("deprecation")
		Pageable pageable = new PageRequest(page, size);
		Page<SystemLog> logs = systemLogDao.findInOrders(pageable);
		return logs;
	}

}
