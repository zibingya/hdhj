package com.hxzy.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.hxzy.dao.PatrolInspectionSheetDao;
import com.hxzy.entity.PatrolInspectionSheet;
import com.hxzy.service.PatrolInspectionSheetService;

@Component(value="patrolInspectionSheetServiceImpl")
public class PatrolInspectionSheetServiceImpl implements PatrolInspectionSheetService{
	
	/**注入PatrolInspectionSheetDao*/
	@Resource
	private PatrolInspectionSheetDao patrolInspectionSheetDao;

	@Transactional
	@Override
	public PatrolInspectionSheet findOnePatrolInspectionSheet(int station_no,String time) {
		// TODO Auto-generated method stub
		return patrolInspectionSheetDao.findOnePIS(station_no, time);
	}
		
}
