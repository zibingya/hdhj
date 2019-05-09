package com.hxzy.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.hxzy.entity.PowerMachine;
import com.hxzy.entity.StationBasic;

public interface PowerMachineDao extends JpaRepository<PowerMachine, Integer>{
	/**
	 * 继承jparespository实现powermachine的增删改查
	 * */
	@Query("from com.hxzy.entity.PowerMachine pm where pm.stationBasic.station_no = :station_no and pm.pm_time =:time")
	public PowerMachine finOnePowerMachine(int station_no,int time);
}
