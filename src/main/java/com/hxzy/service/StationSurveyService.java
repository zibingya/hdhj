package com.hxzy.service;

import java.util.List;

import com.hxzy.entity.StationSurvey;

public interface StationSurveyService {
	public void addStationSurvey(StationSurvey stationSurvey);

	public void delStationSurvey(List<Integer> times);

	public StationSurvey findOneStationSurvey(int station_no, int time);

	public List<StationSurvey> findAllStationSurvey(int station_no);

}
