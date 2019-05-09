package com.hxzy.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;

import com.hxzy.dao.StationBasicDao;
import com.hxzy.entity.StationBasic;
import com.hxzy.service.StationBasicService;

@Component("stationBasicServiceImpl")
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

	@Override
	public StationBasic addStationBasic(StationBasic stationBasic) {
		// TODO Auto-generated method stub
		StationBasic temp = stationBasicDao.saveAndFlush(stationBasic);
		return temp;
	}

	@Override
	public void delStationBasic(StationBasic stationBasic) {
		// TODO Auto-generated method stub
		stationBasicDao.deleteById(stationBasic.getStation_no());
	}

	@Override
	public StationBasic updateStationBasic(StationBasic stationBasic) {
		// TODO Auto-generated method stub
		StationBasic temp = stationBasicDao.saveAndFlush(stationBasic);
		return temp;
	}

	@SuppressWarnings("deprecation")
	@Override
	public Page<StationBasic> fy(int page, int size) {
		// TODO Auto-generated method stub
		Pageable pageable = new PageRequest(page, size);
		Page<StationBasic> stations = stationBasicDao.findInOrders(pageable);
		return stations;
	}
	
	public StationBasic findOne(String station_kind) {
		// TODO Auto-generated method stub
		return stationBasicDao.findOne(station_kind);
	}
}
