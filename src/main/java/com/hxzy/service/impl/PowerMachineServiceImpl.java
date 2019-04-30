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
	public void addPowerMachine(PowerMachine powerMachine) {
		// TODO Auto-generated method stub
		powerMachineDao.save(powerMachine);
	}
 
	@Transactional
	@Override
	public void delPowerMachine(int time) {
		// TODO Auto-generated method stub
		powerMachineDao.deleteById(time);
	}

	@Transactional
	@Override
	public PowerMachine findOnePowerMachine(int station_no,int pm_id) {
		// TODO Auto-generated method stub
		return powerMachineDao.finOnePowerMachine(station_no, pm_id);
	}

}
