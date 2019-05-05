package com.hxzy.service;

import org.springframework.data.domain.Page;

import com.hxzy.entity.SystemLog;

/**
 * 系统日志Service接口
 * @author ZengLang
 * */
public interface SystemLogService {
	//保存
	public SystemLog addSystemLog(SystemLog systemLog);
	
	public Page<SystemLog> fy(int page, int size );
}
