package com.hxzy.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hxzy.entity.Warning;

public interface WarningDao extends JpaRepository<Warning, Integer>{

}
