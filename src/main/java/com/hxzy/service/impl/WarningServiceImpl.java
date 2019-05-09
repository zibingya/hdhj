package com.hxzy.service.impl;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.hxzy.dao.WarningDao;
import com.hxzy.entity.StationBasic;
import com.hxzy.entity.Warning;
import com.hxzy.service.WarningService;
@Component("warningServiceImpl")
public class WarningServiceImpl implements WarningService{
	/**
	 * *set方法注入dao
	 */
	private WarningDao warningDao;
	@Resource
	public void setWarningDao(WarningDao warningDao) {
		this.warningDao = warningDao;
	}
	@Override
	public List<Warning> getWarningList() {
		// TODO Auto-generated method stub
		return warningDao.findAll();
	}
	@Override
	public void deleteWarningList(Warning warning) {
		// TODO Auto-generated method stub
		warningDao.delete(warning);
	}

	@Override
	public void updateinfo(Warning warning) {
		// TODO Auto-generated method stub
		warningDao.updateinfo(warning.getWarning_id());
	}	
}
