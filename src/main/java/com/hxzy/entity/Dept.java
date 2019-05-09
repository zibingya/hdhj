package com.hxzy.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * 部门表
 */
@Entity
@Table(name = "t_dept")
public class Dept implements Serializable {
	private static final long serialVersionUID = 2634688768618250439L;
	// 部门编号
	@Id
	@SequenceGenerator(initialValue = 1, name = "suq_dept", sequenceName = "seq_dept_id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "suq_dept")
	private int deptno;
	// 部门名称
	private String dname;
	// 部门状态
	private String dstate;
	// 部门描述
	private String ddescription;
	// 创建时间
	private String dtime;
	// 创建者
	private String dceater;
	// 修改时间
	private String dchangetime;
	// 修改者
	private String dchanger;
	// 操作者
	private String ip;
	// 日志级别
	private String loglevel;
	// 日志类型
	private String logtype;
	// 描述
	private String description;
	// 详细信息
	private String details;
	// 操作类型
	private String operationtype;
	// 是否成功
	private String whethersucceed;

	public int getDeptno() {
		return deptno;
	}

	public void setDeptno(int deptno) {
		this.deptno = deptno;
	}

	public String getDname() {
		return dname;
	}

	public void setDname(String dname) {
		this.dname = dname;
	}

	public String getDstate() {
		return dstate;
	}

	public void setDstate(String dstate) {
		this.dstate = dstate;
	}

	public String getDdescription() {
		return ddescription;
	}

	public void setDdescription(String ddescription) {
		this.ddescription = ddescription;
	}

	public String getDtime() {
		return dtime;
	}

	public void setDtime(String dtime) {
		this.dtime = dtime;
	}

	public String getDceater() {
		return dceater;
	}

	public void setDceater(String dceater) {
		this.dceater = dceater;
	}

	public String getDchangetime() {
		return dchangetime;
	}

	public void setDchangetime(String dchangetime) {
		this.dchangetime = dchangetime;
	}

	public String getDchanger() {
		return dchanger;
	}

	public void setDchanger(String dchanger) {
		this.dchanger = dchanger;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getLoglevel() {
		return loglevel;
	}

	public void setLoglevel(String loglevel) {
		this.loglevel = loglevel;
	}

	public String getLogtype() {
		return logtype;
	}

	public void setLogtype(String logtype) {
		this.logtype = logtype;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

	public String getOperationtype() {
		return operationtype;
	}

	public void setOperationtype(String operationtype) {
		this.operationtype = operationtype;
	}

	public String getWhethersucceed() {
		return whethersucceed;
	}

	public void setWhethersucceed(String whethersucceed) {
		this.whethersucceed = whethersucceed;
	}

}
