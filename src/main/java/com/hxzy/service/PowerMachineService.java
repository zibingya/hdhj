package com.hxzy.service;

import com.hxzy.entity.PowerMachine;

public interface PowerMachineService {
	public void addPowerMachine(PowerMachine powerMachine);

	public void delPowerMachine(int time);

	public PowerMachine findOne(int time);
}
