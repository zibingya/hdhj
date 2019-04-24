package com.hxzy.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hxzy.entity.PowerMachine;

public interface PowerMachineDao extends JpaRepository<PowerMachine, Integer>{
	/**
	 * 继承jparespository实现powermachine的增删改查
	 * */
}
