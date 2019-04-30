package com.hxzy.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * 考勤记录
 * */
@Entity
@Table(name = "Attendance_Record")
public class AttendanceRecord implements Serializable{

	private static final long serialVersionUID = -4029694778345108290L;

	/** 纪录id */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(nullable = false)
	private int ar_id;

	/** 人员 */
	@ManyToOne(cascade= {CascadeType.MERGE,CascadeType.REFRESH},optional=false)
	@JoinColumn(name="ar_eid")
	private Employee employee;

	/** 到达时间 */
	private int ar_arrivingtime;

	/** 离开时间 */
	private int ar_leavingtime;

	/** 总计时长(minute) */
	private double ar_totaltime;

	/** 是否有效 */
	private boolean ar_wethervalid;

	/** 站点编号 */
	@ManyToOne(cascade = { CascadeType.MERGE, CascadeType.REFRESH }, optional = false) 
	@JoinColumn(name = "ar_station_no")
	private StationBasic stationBasic;

	public int getAr_id() {
		return ar_id;
	}

	public void setAr_id(int ar_id) {
		this.ar_id = ar_id;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public int getAr_arrivingtime() {
		return ar_arrivingtime;
	}

	public void setAr_arrivingtime(int ar_arrivingtime) {
		this.ar_arrivingtime = ar_arrivingtime;
	}

	public int getAr_leavingtime() {
		return ar_leavingtime;
	}

	public void setAr_leavingtime(int ar_leavingtime) {
		this.ar_leavingtime = ar_leavingtime;
	}

	public double getAr_totaltime() {
		return ar_totaltime;
	}

	public void setAr_totaltime(double ar_totaltime) {
		this.ar_totaltime = ar_totaltime;
	}

	public boolean isAr_wethervalid() {
		return ar_wethervalid;
	}

	public void setAr_wethervalid(boolean ar_wethervalid) {
		this.ar_wethervalid = ar_wethervalid;
	}

	public StationBasic getStationBasic() {
		return stationBasic;
	}

	public void setStationBasic(StationBasic stationBasic) {
		this.stationBasic = stationBasic;
	}

}
