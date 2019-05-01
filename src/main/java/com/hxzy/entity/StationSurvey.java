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
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity(name="Station_Survey")
public class StationSurvey implements Serializable{
	/**
	 * 站点检测表
	 * 出水口水水质，出水口流量，电控箱开合状态
	 */
	
	private static final long serialVersionUID = 2913284942655175859L;

	/**日期时刻,主键*/
	@Id
	@SequenceGenerator(initialValue = 1, name = "survey", sequenceName = "seq_stationsurvey_id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "survey")
	private int time;
	
	/**COD(mg/L)*/
	@Column(length=50,nullable=true)
	private double survey_cod; 
	
	/**NH3-N(mg/L)*/
	@Column(length=50,nullable=true)
	private double survey_nh3n;
	
	/**PH*/
	@Column(length=50,nullable=true)
	private double survey_ph; 
	
	/**磷总量*/
	@Column(length=50,nullable=true)
	private double survey_totalp; 
	
	/**水温*/
	@Column(length=50,nullable=true)
	private double survey_watertemperature; 
	
	/**空气温度*/
	@Column(length=50,nullable=true)
	private double survey_airtemperature;
	
	/**瞬时流速*/
	@Column(length=50,nullable=true)
	private double survey_instantspeed; 
	
	/**流量读数*/
	@Column(length=50,nullable=true)
	private double survey_flowmeterReading;
	
	/**今日总流量*/
	@Column(length=50,nullable=true)
	private double survey_totalflowtoday;
	
	/**昨日总流量*/
	@Column(length=50,nullable=true)
	private double survey_totalflowyesterday;
	
	/**数据种类(出水口水质1/出水口水量2/电控箱开合状态0)*/
	@Column(length=50,nullable=true)
	private int survey_datatype;
	
	/**站点编号*/
	@ManyToOne(cascade={CascadeType.MERGE,CascadeType.REFRESH},optional=false)//可选属性optional=false,表示stationbasic不能为空.删除survey不影响stationbasic
	@JoinColumn(name="survey_station_no")//设置在stationsurvey表中的关联字段(外键)
	private StationBasic stationBasic;
	
	/**其他*/
	@Column(length=50,nullable=true)
	private double survey_other;

	public int getTime() {
		return time;
	}

	public void setTime(int time) {
		this.time = time;
	}

	public double getSurvey_cod() {
		return survey_cod;
	}

	public void setSurvey_cod(double survey_cod) {
		this.survey_cod = survey_cod;
	}

	public double getSurvey_nh3n() {
		return survey_nh3n;
	}

	public void setSurvey_nh3n(double survey_nh3n) {
		this.survey_nh3n = survey_nh3n;
	}

	public double getSurvey_ph() {
		return survey_ph;
	}

	public void setSurvey_ph(double survey_ph) {
		this.survey_ph = survey_ph;
	}

	public double getSurvey_totalp() {
		return survey_totalp;
	}

	public void setSurvey_totalp(double survey_totalp) {
		this.survey_totalp = survey_totalp;
	}

	public double getSurvey_watertemperature() {
		return survey_watertemperature;
	}

	public void setSurvey_watertemperature(double survey_watertemperature) {
		this.survey_watertemperature = survey_watertemperature;
	}

	public double getSurvey_airtemperature() {
		return survey_airtemperature;
	}

	public void setSurvey_airtemperature(double survey_airtemperature) {
		this.survey_airtemperature = survey_airtemperature;
	}

	public double getSurvey_instantspeed() {
		return survey_instantspeed;
	}

	public void setSurvey_instantspeed(double survey_instantspeed) {
		this.survey_instantspeed = survey_instantspeed;
	}

	public double getSurvey_flowmeterReading() {
		return survey_flowmeterReading;
	}

	public void setSurvey_flowmeterReading(double survey_flowmeterReading) {
		this.survey_flowmeterReading = survey_flowmeterReading;
	}

	public double getSurvey_totalflowtoday() {
		return survey_totalflowtoday;
	}

	public void setSurvey_totalflowtoday(double survey_totalflowtoday) {
		this.survey_totalflowtoday = survey_totalflowtoday;
	}

	public double getSurvey_totalflowyesterday() {
		return survey_totalflowyesterday;
	}

	public void setSurvey_totalflowyesterday(double survey_totalflowyesterday) {
		this.survey_totalflowyesterday = survey_totalflowyesterday;
	}

	public int getSurvey_datatype() {
		return survey_datatype;
	}

	public void setSurvey_datatype(int survey_datatype) {
		this.survey_datatype = survey_datatype;
	}

	public StationBasic getStationBasic() {
		return stationBasic;
	}

	public void setStationBasic(StationBasic stationBasic) {
		this.stationBasic = stationBasic;
	}

	public double getSurvey_other() {
		return survey_other;
	}

	public void setSurvey_other(double survey_other) {
		this.survey_other = survey_other;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
