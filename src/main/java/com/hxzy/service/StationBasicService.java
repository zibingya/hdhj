package com.hxzy.service;

import java.util.List;

import com.hxzy.entity.StationBasic;

/**
 * 站点信息服务接口
 * */
public interface StationBasicService {
	//查找所有的站点信息
	public List<StationBasic> getStationBasicList();
}
