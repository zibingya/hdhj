package com.hxzy.service.impl;

import java.util.List;

import javax.annotation.Resource;

import com.hxzy.dao.StationBasicDao;
import com.hxzy.entity.StationBasic;
import com.hxzy.service.StationBasicService;

public class StationBasicServiceImpl implements StationBasicService {
	//与dao层的连接
	private StationBasicDao stationBasicDao;

	//通过spring控制生命周期
	@Resource
	public void setStationBasicDao(StationBasicDao stationBasicDao) {
		this.stationBasicDao = stationBasicDao;
	}

	@Override
	public List<StationBasic> getStationBasicList() {
		// TODO Auto-generated method stub
		return stationBasicDao.findAll();
	}
	
	
}
