package com.hxzy.service;

import com.hxzy.entity.SystemLog;

/**
 * 系统日志Service接口
 * @author ZengLang
 * */
public interface SystemLogService {
	//保存
	public SystemLog addSystemLog(SystemLog systemLog);
}
