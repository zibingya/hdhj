package com.hxzy.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.hxzy.dao.SystemLogDao;
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

}
