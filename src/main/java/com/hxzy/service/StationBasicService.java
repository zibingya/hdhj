package com.hxzy.service;

import java.util.List;

import com.hxzy.entity.StationBasic;

import net.sf.json.JSONObject;

/**
 * 站点信息服务接口
 * */
public interface StationBasicService {
	public void addStationBasic(StationBasic stationBasic);
	
	public void delStationBasic(int station_no);

	public StationBasic findStationBasic(int station_no);
	
	public List<StationBasic> getStationBasicList();
}