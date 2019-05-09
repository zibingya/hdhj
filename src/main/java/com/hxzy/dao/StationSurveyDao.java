package com.hxzy.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.hxzy.entity.StationSurvey;

public interface StationSurveyDao extends JpaRepository<StationSurvey,Integer>{
	/**
	 * 站点基础信息dao接口
	 * 继承父类实现站点信息的增删改查
	 * */
	
	@Query("from com.hxzy.entity.StationSurvey s where s.time in :times")
	public void delStationSurveyById(List<Integer> times);

	@Query("from com.hxzy.entity.StationSurvey s where s.stationBasic.station_no =:station_no and s.time=:time")
	public StationSurvey findOneStationSurvey(int station_no,int time);

	@Query("from com.hxzy.entity.StationSurvey ssurvey where ssurvey.stationBasic.station_no =:station_no")
	public List<StationSurvey> findOneStationAllStationSurvey(int station_no);

}
