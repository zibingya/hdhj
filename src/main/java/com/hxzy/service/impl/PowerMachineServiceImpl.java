package com.hxzy.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.hxzy.dao.PowerMachineDao;
import com.hxzy.entity.PowerMachine;
import com.hxzy.service.PowerMachineService;

@Component(value="powerMachineServiceImpl")
public class PowerMachineServiceImpl implements PowerMachineService{
	
	/**
	 * 注入powermachinedao
	 * */
	@Resource(name="powerMachineDao")
	private PowerMachineDao powerMachineDao;


	@Transactional
	@Override
	public PowerMachine findOnePowerMachine(int station_no,int time) {
		// TODO Auto-generated method stub
		return powerMachineDao.finOnePowerMachine(station_no,time);
	}

}
