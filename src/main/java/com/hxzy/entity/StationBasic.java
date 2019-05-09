package com.hxzy.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

/**
 * 站点基础信息
 */
@Entity(name = "Station_Basic")
public class StationBasic implements Serializable {
	private static final long serialVersionUID = 2521996776412219257L;

	/**站点编号*/
	@Id
	@SequenceGenerator(initialValue = 1, name = "suq_station", sequenceName = "seq_station_id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "suq_station")
	private int station_no;

	/**站点类型*/
	@Column(length = 50, nullable = true)
	private String station_kind;
	
	/**站点名称*/
	@Column(length = 50, nullable = true)
	private String station_name;
	
	/**联系方式*/
	@Column(length = 50, nullable = true)
	private String station_phone;
	
	/**站点管理员*/
	@Column(length = 50, nullable = true)
	private String station_manager;
	
	/**所属乡镇*/
	@Column(length = 50, nullable = true)
	private String station_town;
	
	/**所在村*/
	@Column(length = 50, nullable = true)
	private String station_village;

	/**经度*/
	private int station_longitude;
	
	/**纬度*/
	private int station_latitude;

	/** 站点描述*/
	@Column(length = 100, nullable = true)
	private String station_description;
	
	/**照片原名*/
	@Column(length = 50, nullable = true)
	private String station_pictureoldname;
	
	/**照片新名*/
	@Column(length = 50, nullable = true)
	private String station_picturenewname;
	
	/**照片地址*/
	@Column(length = 50, nullable = true)
	private String station_pictureurl;// 
	
	/**水流量警告类型*/
	@Column(length = 100, nullable = true)
	private String station_waterwarningtype;
	
	/**上限值倍数*/
	private double station_watermax;// 
	
	/**下限值倍数*/
	private double station_watermin;

	/**
	 * stationsurvey(站点检测表集合)*/
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "survey_station_no", referencedColumnName = "station_no")
	private Set<StationSurvey> surveySet = new HashSet<StationSurvey>();

	/**
	 * PatrolInspectionSheet(巡检工单表)集合*/
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "pis_station_no", referencedColumnName = "station_no")
	private Set<PatrolInspectionSheet> pisSet = new HashSet<PatrolInspectionSheet>();
	
	/**
	 * powermachine(动力设备)集合*/
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name="pm_station_name", referencedColumnName = "station_name")
	private Set<PowerMachine> pmSet = new HashSet<PowerMachine>();

	public int getStation_no() {
		return station_no;
	}

	public void setStation_no(int station_no) {
		this.station_no = station_no;
	}

	public String getStation_kind() {
		return station_kind;
	}

	public void setStation_kind(String station_kind) {
		this.station_kind = station_kind;
	}

	public String getStation_name() {
		return station_name;
	}

	public void setStation_name(String station_name) {
		this.station_name = station_name;
	}

	public String getStation_phone() {
		return station_phone;
	}

	public void setStation_phone(String station_phone) {
		this.station_phone = station_phone;
	}

	public String getStation_manager() {
		return station_manager;
	}

	public void setStation_manager(String station_manager) {
		this.station_manager = station_manager;
	}

	public String getStation_town() {
		return station_town;
	}

	public void setStation_town(String station_town) {
		this.station_town = station_town;
	}

	public String getStation_village() {
		return station_village;
	}

	public void setStation_village(String station_village) {
		this.station_village = station_village;
	}

	public int getStation_longitude() {
		return station_longitude;
	}

	public void setStation_longitude(int station_longitude) {
		this.station_longitude = station_longitude;
	}

	public int getStation_latitude() {
		return station_latitude;
	}

	public void setStation_latitude(int station_latitude) {
		this.station_latitude = station_latitude;
	}

	public String getStation_description() {
		return station_description;
	}

	public void setStation_description(String station_description) {
		this.station_description = station_description;
	}

	public String getStation_pictureoldname() {
		return station_pictureoldname;
	}

	public void setStation_pictureoldname(String station_pictureoldname) {
		this.station_pictureoldname = station_pictureoldname;
	}

	public String getStation_picturenewname() {
		return station_picturenewname;
	}

	public void setStation_picturenewname(String station_picturenewname) {
		this.station_picturenewname = station_picturenewname;
	}

	public String getStation_pictureurl() {
		return station_pictureurl;
	}

	public void setStation_pictureurl(String station_pictureurl) {
		this.station_pictureurl = station_pictureurl;
	}

	public String getStation_waterwarningtype() {
		return station_waterwarningtype;
	}

	public void setStation_waterwarningtype(String station_waterwarningtype) {
		this.station_waterwarningtype = station_waterwarningtype;
	}

	public double getStation_watermax() {
		return station_watermax;
	}

	public void setStation_watermax(double station_watermax) {
		this.station_watermax = station_watermax;
	}

	public double getStation_watermin() {
		return station_watermin;
	}

	public void setStation_watermin(double station_watermin) {
		this.station_watermin = station_watermin;
	}

	public Set<StationSurvey> getSurveySet() {
		return surveySet;
	}

	public void setSurveySet(Set<StationSurvey> surveySet) {
		this.surveySet = surveySet;
	}

	public Set<PatrolInspectionSheet> getPisSet() {
		return pisSet;
	}

	public void setPisSet(Set<PatrolInspectionSheet> pisSet) {
		this.pisSet = pisSet;
	}

	public Set<PowerMachine> getPmSet() {
		return pmSet;
	}

	public void setPmSet(Set<PowerMachine> pmSet) {
		this.pmSet = pmSet;
	}

}