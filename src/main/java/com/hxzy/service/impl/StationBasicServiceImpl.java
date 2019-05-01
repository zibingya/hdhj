package com.hxzy.service.impl;

import java.util.List;

import javax.annotation.Resource;


import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.hxzy.dao.StationBasicDao;
import com.hxzy.entity.StationBasic;
import com.hxzy.service.StationBasicService;

@Component(value="stationBasicService")
public class StationBasicServiceImpl implements StationBasicService{
	
	/**
	 * 注入stationBasicDao
	 * */
	@Resource
	private StationBasicDao stationBasicDao;
	
	/**
	 * 添加基础信息服务
	 * 首先会存入图片存入的名字
	 * 日期时分秒+原名
	 * */
	@Transactional
	@Override
	public void addStationBasic(StationBasic stationBasic) {
		// TODO Auto-generated method stub
		stationBasicDao.save(stationBasic);
	}

	@Transactional
	@Override
	public void delStationBasic(int station_no) {
		// TODO Auto-generated method stub
		stationBasicDao.deleteById(station_no);
	}

	@Transactional
	@Override
	public StationBasic findStationBasic(int id) {
		// TODO Auto-generated method stub
		return stationBasicDao.finOne(id);
	}

	@Override
	public List<StationBasic> getStationBasicList() {
		// TODO Auto-generated method stub
		return stationBasicDao.findAll();
	}
	
}
