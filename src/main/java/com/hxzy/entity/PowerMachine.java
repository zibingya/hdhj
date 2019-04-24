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

@Entity
@Table(name = "PowerMachine")
public class PowerMachine implements Serializable{
	private static final long serialVersionUID = 5915110881404758179L;

	/**
	 * 动力设备
	 * */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(nullable = false)
	private int pm_id;// 源设备地址

	@Column(length = 50, nullable = true)
	private String pm_address;// 寄存器地址

	private boolean pm_state;// 互感器运行状态

	@Column(length = 50, nullable = true)
	private int pm_line;// 设备线路
	
	/**pm_station_name外键关联站点名station_name*/
	@ManyToOne(cascade= {CascadeType.MERGE,CascadeType.REFRESH},optional=false)//删除该表不影响是stationbasic
	@JoinColumn(name="pm_station_name")
	private StationBasic stationBasic;
	
	@Column(length = 50, nullable = true)
	private String pm_other;// 其他

	public int getPm_id() {
		return pm_id;
	}

	public void setPm_id(int pm_id) {
		this.pm_id = pm_id;
	}

	public String getPm_address() {
		return pm_address;
	}

	public void setPm_address(String pm_address) {
		this.pm_address = pm_address;
	}

	public boolean isPm_state() {
		return pm_state;
	}

	public void setPm_state(boolean pm_state) {
		this.pm_state = pm_state;
	}

	public int getPm_line() {
		return pm_line;
	}

	public void setPm_line(int pm_line) {
		this.pm_line = pm_line;
	}

	public StationBasic getStationBasic() {
		return stationBasic;
	}

	public void setStationBasic(StationBasic stationBasic) {
		this.stationBasic = stationBasic;
	}

	public String getPm_other() {
		return pm_other;
	}

	public void setPm_other(String pm_other) {
		this.pm_other = pm_other;
	}

}
