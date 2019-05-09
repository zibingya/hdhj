
package com.hxzy.service;

import java.util.List;

import com.hxzy.entity.Warning;

/**
 * *告警列表接口
 * @author Administrator
 *
 */
public interface WarningService {
	
	public List<Warning> getWarningList();//查找告警列表信息	
	
	public void deleteWarningList(Warning warning);//删除告警列表
	
	
	public void updateinfo(Warning warning);//更新告警信息
}
