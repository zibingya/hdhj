package com.hxzy.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.hxzy.entity.StationBasic;

/**
 * 站点信息服务接口
 * */
public interface StationBasicService {
	//查找所有的站点信息
	public List<StationBasic> getStationBasicList();
	//新增站点
	public StationBasic addStationBasic(StationBasic stationBasic);
	//删除站点
	public void delStationBasic(StationBasic stationBasic);
	//更新
	public StationBasic updateStationBasic(StationBasic stationBasic);
	//分页
	public Page<StationBasic> fy(int page, int size);
	//hzl 按照类型查站点
	public StationBasic findOne(String station_kind);
}
