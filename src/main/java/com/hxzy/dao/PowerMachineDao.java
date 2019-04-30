package com.hxzy.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.hxzy.entity.PowerMachine;
import com.hxzy.entity.StationBasic;

public interface PowerMachineDao extends JpaRepository<PowerMachine, Integer>{
	/**
	 * 继承jparespository实现powermachine的增删改查
	 * */
	@Query("from PowerMachine pm,StationBasic s where s.station_no = :station_no and pm.stationBasic.station_no = s.station_no and pm.id = :id")
	public PowerMachine finOnePowerMachine(int station_no,int id);
}
