package com.hxzy.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hxzy.entity.SystemLog;



public interface SystemLogDao extends JpaRepository<SystemLog, Integer> {

}
