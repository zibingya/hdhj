package com.hxzy.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.hxzy.dao.StationSurveyDao;
import com.hxzy.entity.StationSurvey;
import com.hxzy.service.StationSurveyService;

@Component(value="stationSurveyService")
public class StationSurveyServiceImpl implements StationSurveyService{
	
	/**
	 * 注入stationsurveydao
	 * */
	@Resource()
	private StationSurveyDao stationSurveyDao;

	@Transactional
	@Override
	public void addStationSurvey(StationSurvey stationSurvey) {
		// TODO Auto-generated method stub
		stationSurveyDao.save(stationSurvey);
	}

	@Transactional
	@Override
	public void delStationSurvey(List<Integer> ids) {
		// TODO Auto-generated method stub
		stationSurveyDao.delStationSurveyById(ids);
	}

	@Transactional
	@Override
	public StationSurvey findOneStationSurvey(int station_no,int time) {
		// TODO Auto-generated method stub
		return stationSurveyDao.findOneStationSurvey(station_no,time);
	}

	@Transactional
	@Override
	public List<StationSurvey> findAllStationSurvey(int station_no) {
		// TODO Auto-generated method stub
		return stationSurveyDao.findOneStationAllStationSurvey(station_no);
	}

}
