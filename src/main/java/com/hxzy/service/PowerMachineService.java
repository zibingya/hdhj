package com.hxzy.service;

import com.hxzy.entity.PowerMachine;

public interface PowerMachineService {
	public void addPowerMachine(PowerMachine powerMachine);

	public void delPowerMachine(int time);

	public PowerMachine findOnePowerMachine(int station_no,int pm_id);
}
