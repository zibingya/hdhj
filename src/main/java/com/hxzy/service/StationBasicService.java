package com.hxzy.service;

import java.util.List;

import com.hxzy.entity.StationBasic;

public interface StationBasicService {
	public void addStationBasic(StationBasic stationBasic);

	public void delStationBasic(int station_no);

	public StationBasic findStationBasic(int station_no);

	public List<StationBasic> findStationBasic();
}
