package com.hxzy.dao;

import javax.transaction.Transactional;

import org.hibernate.metamodel.model.convert.internal.JpaAttributeConverterImpl;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.support.JpaRepositoryFactory;

import com.hxzy.entity.AttendanceLaw;
import com.hxzy.entity.Warning;

public interface AttendanceLawDao extends JpaRepository<AttendanceLaw, Integer>{
}
